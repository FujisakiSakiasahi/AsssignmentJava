import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab3 implements ActionListener{
    //card layout for tab 3
    private JPanel card = new JPanel() ;
    
    //components for the third tab
    private JLabel heading = new JLabel("Editing player information: ") ;
    private JLabel nameInputLabel = new JLabel("Name:") ;
    private JTextField nameInput = new JTextField(10) ;
    private JButton search = new JButton("Search") ;
    private JTextField nameEditInput = new JTextField(10) ;
    private JLabel pointInputLabel = new JLabel("Point:") ;
    private JTextField pointEditInput = new JTextField(10) ;
    private JButton clear = new JButton("Clear") ;
    private JButton submit = new JButton("Save and change") ;

    public Tab3(){
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

        nameEditInput.setEditable(false);
        pointEditInput.setEditable(false);
        clear.setEnabled(false);
        submit.setEnabled(false);

    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
