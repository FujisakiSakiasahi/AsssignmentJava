import java.io.Serializable;

public class Player implements Serializable{
    private static final long serialVersionUID = 1L;
    private String name;
    private int points;
    private int wins, loses ;
    static int num = 0;
    
    //constructor
    public Player(String name, int points){
        this.name = name;
        this.points = points;
        wins = 0 ;
        loses = 0 ;
        num++;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPoints(int points){
        this.points = points;
    }

    public void setWL(int wins, int loses){
        this.wins = wins ;
        this.loses = loses ;
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
        return ("Player Name: " + name + "\nPoints: " + points + "\nWin: " + wins + "\nLose: " + loses + "\nWinrate: " + calWLR()); 
    }
}