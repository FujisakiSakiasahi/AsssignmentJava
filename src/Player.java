public class Player{
    private int id;
    private String name;
    private int points;
    static int num = 0;
    
    //constructor
    public Player(String name, int points){
        this.id = 100 + num;
        this.name = name;
        this.points = points;
        num++;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setPoints(int points){
        this.points = points;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    //display
    public String toString(){
        return ("Player ID: " + id + "\nPlayer Name: " + name + "\nPoints: " + points + "\n"); 
    }
}