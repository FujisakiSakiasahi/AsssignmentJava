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

}
