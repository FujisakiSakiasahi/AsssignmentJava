import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class App {
    public static boolean checkPlayer(String name){
        File file = new File("PlayerRecord\\"+name+".txt") ;
        
        if(file.exists()){
            return true ;
        }else{
            return false ;
        }
    }

    public static void createPlayer(Player newPlayer){
        try {
            File newFile = new File(new File("").getAbsolutePath() + "\\PlayerRecord\\"+newPlayer.getName()+".txt") ;
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
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


    public static void removePlayer(ArrayList<Player> playerList){
        clearScreen();
        String name;

        System.out.println("Please enter the player name that you want to delete: ");
        name = sc.nextLine();

        for (Player x:playerList){
            if (x.getName().equals(name)){
                playerList.remove(x);
                System.out.println("Deleted player " + name);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                return;
            }
        }

        System.out.println("Player not found.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        clearScreen();

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

    public static void readPlayers(ArrayList<Player> playerList){
        try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File("Players.txt")));

            while(true){
                try{
                    Player p1;
                    p1 = (Player) input.readObject();
                    Player.num++;
                    playerList.add(p1);
                }catch(EOFException e){
                    break;
                }
            }
                
            input.close();

        }catch(FileNotFoundException e) {
            return;
        }catch(IOException e) {
            System.out.println("Error initializing stream");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
