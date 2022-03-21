import java.awt.*;
import java.util.ArrayList;

//import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame{
    final static String ADDNEW = "Create new player" ;
    final static String REMOVE = "Remove player" ;
    final static String EDITPLAYERINFO = "Edit player information" ;
    final static String DISPLAY = "Show all player" ;

    final static int extraWindowWidth = 100;

    public void addComponentToPane(Container pane){
        JTabbedPane tabbedpane = new JTabbedPane() ;
        
        //link the contain of all tab to this file
        Tab1 card1 = new Tab1() ;
        Tab2 card2 = new Tab2() ;
        Tab3 card3 = new Tab3() ;
        Tab4 card4 = new Tab4() ;        

        //add tabs
        tabbedpane.addTab(ADDNEW, card1.getCard());
        tabbedpane.addTab(REMOVE, card2.getCard());
        tabbedpane.addTab(EDITPLAYERINFO, card3.getCard());
        tabbedpane.addTab(DISPLAY, card4.getCard());
        
        //main layout, add everything
        pane.add(tabbedpane) ;
    }

    public static void callWindow(){
        JFrame frame = new JFrame("Yes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //dun know why cannot work
        //frame.setLocationRelativeTo(null);
        
        GUI window = new GUI() ;
        window.addComponentToPane(frame.getContentPane()) ;

        frame.pack() ;
        frame.setVisible(true);
        
        frame.setSize(600, 400);
        frame.setResizable(false) ;
    }

    public static void main(String[] args){
        // ArrayList<Player> playerList = new ArrayList<Player>();
        // App.readPlayers(playerList);
        
        callWindow();
    }

}