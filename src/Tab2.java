import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab2 implements ActionListener{
    //card layout for tab 2
    private JPanel card = new JPanel() ;

    public Tab2(){
        //components for the second tab
        JLabel heading = new JLabel("Removing exiting player: ") ;
        JLabel nameInputLabel = new JLabel("Name:") ;
        JTextField nameInput = new JTextField(10) ;
        JButton search = new JButton("Search") ;
        JTextArea result = new JTextArea(2,1) ;// result display
        JButton remove = new JButton("Remove") ;
        
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
        JPanel l3 = new JPanel() ;
        l3.setLayout(new FlowLayout(FlowLayout.LEFT));
        result.setEditable(false);
        result.setText("Name: " + "\nPoint: ");
        l3.add(result) ;

        //group line 4
        JPanel l4 = new JPanel() ;
        l4.setLayout(new FlowLayout(FlowLayout.LEFT));
        l4.add(remove) ;

        //add all group to card
        card.add(l1) ;
        card.add(l2) ;
        card.add(l3) ;
        card.add(l4) ;
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
