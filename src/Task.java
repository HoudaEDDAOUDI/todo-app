public class Task{
    private int id;
    private String title;
    private String status;

    public Task(int id, String title, String status){
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public String toString(){
        return "Numéro : "+id+", Titre : "+title+", Statut : "+status;
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getStatus(){
        return this.status;
    }
}