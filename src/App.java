import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void printMainMenu(){
        System.out.print("1) Create new player \n2) Remove player \n3) Edit Player Information \n4) Show all players \n5) Exit \n\nChoose option (1-5): ");
    }

    public static void clearScreen(){
        System.out.print("\033[H\033[2J"); //cls
        System.out.flush();
    }

    public static Player createPlayer(Scanner sc){
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

    public static void removePlayer(ArrayList<Player> playerList,Scanner reader){
        clearScreen();
        String name;

        System.out.println("Please enter the player name that you want to delete: ");
        name = reader.nextLine();

        System.out.println(name);

        for(Player x : playerList){
            System.out.println(x.getName());
            if(name==x.getName()){
                playerList.remove(x);
                return;
            }
        }
        System.out.println("Invalid Name");
    }

    public static void printAllPlayers(ArrayList<Player> playerList, Scanner sc){
        clearScreen();
        System.out.println("Players: ");
        for (Player x : playerList){
            System.out.println(x.toString()); //printing
        }
        
        System.out.println("Press enter to continue..."); //system pause

        sc.nextLine();

        clearScreen();

    }


    public static void main(String[] args) throws Exception {
        clearScreen();
        Scanner sc = new Scanner(System.in);
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
                playerList.add(createPlayer(sc));
            }else if (choice == 2){
                removePlayer(playerList,sc);
            }else if (choice == 3){

            }else if (choice == 4){
                printAllPlayers(playerList, sc);
            }else if (choice == 5){
                break;
            }else{
                System.out.println("Error, input out of range.");
            }

        }

        sc.close();
    }
}
