import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void printMainMenu(){
        System.out.print("1) Create new player \n2) Remove player \n3) Edit Player Information \n4) Show all players \n5) Exit \n\nChoose option (1-5): ");
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

        return new Player(name, points);

    }

    public static void printAllPlayers(ArrayList<Player> playerList){
        for (Player x : playerList){
            System.out.println(x.toString());
        }
    }

    public static void main(String[] args) throws Exception {
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
                
            }else if (choice == 3){

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
