import java.io.Serializable;


public class Player implements Serializable{
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int points;
    private int wins, loses ;
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

    public void win(){
        wins++;
    }

    public void lose(){
        loses++;
    }

    public double calWLR(){
        if (loses == 0){
            return Double.valueOf(wins);
        }else{
            return wins / loses;
        }
    }

    //display
    @Override
    public String toString(){
        return ("Player ID: " + id + "\nPlayer Name: " + name + "\nPoints: " + points + "\n"); 
    }
}