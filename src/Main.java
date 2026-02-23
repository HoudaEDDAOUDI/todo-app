import java.util.Scanner;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        
        try{
            Scanner scanner = new Scanner(System.in);
            TasksManager myTasks = new TasksManager(scanner);
        
            while (true) {
                System.out.println("Bonjour, que souhaitez-vous faire aujourd'hui?");
                System.out.println("Ajouter | Supprimer | Afficher | Voir une tache | Quitter");
                String choix = scanner.nextLine();

                switch (choix.toLowerCase()) {
                    case "ajouter":
                        myTasks.add();
                        break;
                    case "supprimer":
                        myTasks.remove();
                        break;
                    case "afficher":
                        myTasks.getAllTasks();
                        break;
                    case "voir une tache":
                        myTasks.getOneTasks();
                        break;
                    case "quitter":
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Je n'ai pas bien compris votre demande.");
                        break;
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}