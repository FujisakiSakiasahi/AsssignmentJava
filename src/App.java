import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class App {
    
    /**
     * Use to check if player name is in used
     * 
     * @param name the name of the player that need to be checked
     */
    public static boolean checkPlayer(String name){
        File file = new File("lib\\"+name+".txt") ;
        
        if(file.exists()){
            return true ;
        }else{
            return false ;
        }
    }

    public static void createPlayer(Player newPlayer){
        try {
            new File("lib", newPlayer.getName()+".txt") ;
            FileWriter fw = new FileWriter("lib\\"+newPlayer.getName()+".txt") ;
            fw.write(newPlayer.toString()) ;
            fw.close() ;

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String readPlayers(String name){
        File readFile = new File("lib\\"+name+".txt") ;
        String data = "";

        try{
            Scanner sc = new Scanner(readFile) ;
            
            while(sc.hasNextLine()){
                data += sc.nextLine() + "\n" ;
            }
            sc.close();

        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return data ;
    }

    public static String[] getPlayer(String name){
        File readFile = new File("lib\\"+name+".txt") ;
        String[] data = new String[5] ;
        int i = 0 ;

        try{
            Scanner sc = new Scanner(readFile) ;
            
            while(sc.hasNextLine()){
                data[i] = sc.nextLine() ;
                i++ ;
            }
            sc.close();

        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[] record = new String[i];
        for(int j = 0 ; j < i ; j++){
            String[] array = data[j].split(": ", 2) ;
            record[j] = array[1] ;
        }

        return record ;
    }
                
    public static void removePlayer(String name){
        File toDelFile = new File("lib", name+".txt") ;
        try {
            toDelFile.delete();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
    }

    static Scanner sc = new Scanner(System.in);

    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //cls
        System.out.flush();
    }

    public static void EditPlayerInformation(ArrayList<Player> playerList){
        clearScreen();
        String name;
        String newName;

        System.out.println("Please enter the player name that you want to edit: ");
        name = sc.nextLine();

        
        for(Player x : playerList){
            if(name.equals(x.getName())){
                System.out.println("Please enter a new name for the player: ");
                
                newName = sc.nextLine();
                x.setName(newName);
                System.out.println("The name has change to " + newName);
                return;
            }
        }
        System.out.println("Player Not Found.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        clearScreen();
    }

    public static void printAllPlayers(ArrayList<Player> playerList){
        clearScreen();
        System.out.println("Players: ");
        for (Player x : playerList){
            System.out.println(x); //printing
        }
        
        System.out.println("Press enter to continue..."); //system pause

        sc.nextLine();

        clearScreen();

    }

    public static void savePlayers(ArrayList<Player> playerList){
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(new File("Players.txt")));

            for (Player x : playerList){
                output.writeObject(x);
                System.out.println("Saved player " + x.getName());
            }

            output.close();

        }catch (FileNotFoundException e) {
			System.out.println("File not found");
		}catch (IOException e) {
			System.out.println("Error initializing stream");
		}
    }

}
