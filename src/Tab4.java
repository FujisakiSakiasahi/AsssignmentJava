import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab4 implements ActionListener{
    //card layout for tab 4
    private JPanel card = new JPanel() ;

    public Tab4(){
        //components for the fouth tab
        JLabel test = new JLabel("Test4") ;

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        card.add(test) ;
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}
