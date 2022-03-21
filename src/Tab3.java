import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab3 implements ActionListener{
    //card layout for tab 3
    private JPanel card = new JPanel() ;

    public Tab3(){
        //components for the third tab
        JLabel heading = new JLabel("Editing player information: ") ;
        JLabel nameInputLabel = new JLabel("Name:") ;
        JTextField nameInput = new JTextField(10) ;
        JButton search = new JButton("Search") ;
        JTextField nameEditInput = new JTextField(10) ;
        JLabel pointInputLabel = new JLabel("Point:") ;
        JTextField pointEditInput = new JTextField(10) ;
        JButton clear = new JButton("Clear") ;
        JButton submit = new JButton("Save and change") ;

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        //group line 1
        JPanel l1 = new JPanel() ;
        l1.setLayout(new FlowLayout(FlowLayout.LEFT));
        l1.add(heading) ;

        //group line 2
        JPanel l2 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l2.add(nameInputLabel) ;
        l2.add(nameInput) ;
        l2.add(search) ;

        //group line 3
        JPanel l3 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l3.add(nameInputLabel) ;
        l3.add(nameEditInput) ;

        //group line 3
        JPanel l4 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l4.add(pointInputLabel) ;
        l4.add(pointEditInput) ;

        //group line 3
        JPanel l5 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l5.add(clear) ;
        l5.add(submit) ;
        
        //add all group to card
        card.add(l1) ;
        card.add(l2) ;
        card.add(l3) ;
        card.add(l4) ;
        card.add(l5) ;
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
