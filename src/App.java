import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void printMainMenu(){
        System.out.print("1) Create new player \n2) Remove player \n3) Edit Player Information \n4) Show all players \n5) Exit \n\nChoose option (1-5): ");
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //cls
        System.out.flush();
    }

    public static Player createPlayer(){
        String name;
        int points;

        System.out.print("Enter player name: ");
        name = sc.nextLine();

        while(true){
            System.out.print("Enter " + name + "'s points: ");
            if(sc.hasNextInt()){
                points = sc.nextInt();
                sc.nextLine();
                break;
            }else{
                System.out.println("Error, invalid input.");
                sc.next();
            }
        }

        clearScreen();
        return new Player(name, points);

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

    }

    public static void EditPlayerInformation(ArrayList<Player> playerList){
        clearScreen();
        String name;
        String newName;

        System.out.println("Please enter the player name that you want to edit: ");
        name = sc.nextLine();

        System.out.println("Please enter a new name for the player: ");
        newName = sc.nextLine();

        for(Player x : playerList){
            if(name.equals(x.getName())){
                x.setName(newName);
                System.out.println("The name has change to " + newName);
                return;
            }
        }
        System.out.println("Invalid Name");
    }

    public static void printAllPlayers(ArrayList<Player> playerList){
        clearScreen();
        System.out.println("Players: ");
        System.out.println("ID\tName\tPoints\tWLR");
        for (Player x : playerList){
            System.out.println(x); //printing
        }
        
        System.out.println("Press enter to continue..."); //system pause

        sc.nextLine();

        clearScreen();

    }

    public static void main(String[] args){
        clearScreen();
        ArrayList<Player> playerList = new ArrayList<Player>();
        
        while(true){
            int choice = 0;
            printMainMenu();

            if(sc.hasNextInt()){
                choice = sc.nextInt();
                sc.nextLine();
            }else{
                System.out.println("Error, invalid input.");
                sc.next();
            }

            if (choice == 1){
                playerList.add(createPlayer());
            }else if (choice == 2){
                removePlayer(playerList);
            }else if (choice == 3){
                EditPlayerInformation(playerList);
            }else if (choice == 4){
                printAllPlayers(playerList);
            }else if (choice == 5){
                break;
            }else{
                System.out.println("Error, input out of range.");
            }

        }

        sc.close();
    }
}
