import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TasksManager{
    Scanner scanner;
    FileWriter FileWriter;
    BufferedWriter writer;
    FileReader FileReader;
    BufferedReader reader;
    int id;

    List<Task> Tasks = new ArrayList<>();

    public TasksManager(Scanner scanner) throws IOException {
        this.scanner = scanner;

        // Permet d'ajouter des tâches dans le fichier txt
        this.FileWriter = new FileWriter("../allMyTasks.txt", true);
        this.writer = new BufferedWriter(FileWriter);

        // Permet de lire le fichier txt 
        this.FileReader = new FileReader("../allMyTasks.txt");
        this.reader = new BufferedReader(FileReader);

        charger();
    }     

    public void charger() throws IOException {
        String line = reader.readLine();
        while (line != null) {
            String[] morceaux = line.split(";");
            Task newTask = new Task(Integer.parseInt(morceaux[0]),morceaux[1],morceaux[2]);
            Tasks.add(newTask);
            line = reader.readLine();
        }
        reader.close();
        this.id = Tasks.size();
    } 

    public void add() throws IOException {

        System.out.println("Quel est le titre de votre tâche ? ");
        String title = scanner.nextLine();

        System.out.println("Quel est le statut de votre tâche ? ");
        String status = scanner.nextLine();

        Task newTask = new Task(id, title, status);
        Tasks.add(newTask);
        
        writer.write(id+";"+title+";"+status);
        writer.newLine();
        writer.flush();
        
        System.out.println("Tache ajouté :"+Tasks);

        id++;
    }

    public void remove() throws IOException{
        System.out.println("Quel est l'id de tâche que vous souhaitez supprimer?");
        int idRemove = Integer.parseInt(scanner.nextLine());

        Tasks.removeIf(n->n.getId() == idRemove);

        // Permet de supprimer des tâches dans le fichier txt
        FileWriter fw = new FileWriter("../allMyTasks.txt", false);
        BufferedWriter bw = new BufferedWriter(fw);

        for(Task task : Tasks){
            bw.write(task.getId()+";"+task.getTitle()+";"+task.getStatus());
            bw.newLine();
            bw.flush();
        }
        System.out.println("Tache supprimé!");
    }

    public void getAllTasks() {
        if(Tasks.size() == 0){
            System.out.println("Vous n'avez pas de tâche en cours.");
        }else{
            for (Task task : Tasks) {
                System.out.println("Voici la tâche "+task.getId()+"/ titre : "+task.getTitle()+" et son statut : "+task.getStatus());
            }   
        }
    }

    public void getOneTasks(){
        System.out.println("Quel est l'id de tâche que vous souhaitez voir?");
        int idSee = Integer.parseInt(scanner.nextLine());
        Task resultat = Tasks.stream().filter(f -> f.getId() == idSee).findFirst().orElse(null);
        if (resultat == null) {
            System.out.println("Tâche introuvable !");
        } else {
            System.out.println(resultat);
        }
    }
}