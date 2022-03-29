import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab2 implements ActionListener{
    //card layout for tab 2
    private JPanel card = new JPanel() ;
    
    //components for the second tab
    private JLabel heading = new JLabel("Removing exiting player: ") ;
    private JLabel nameInputLabel = new JLabel("Name:") ;
    private JTextField nameInput = new JTextField(10) ;
    private JButton search = new JButton("Search") ;
    private JTextArea result = new JTextArea(2,1) ;// result display
    private JButton remove = new JButton("Remove") ;

    public Tab2(){
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
        result.setText("Player Name: -" + "\nPoints: -"  + "\nWin: -"  + "\nLose: -"  + "\nWinrate: -" );
        l3.add(result) ;

        //group line 4
        JPanel l4 = new JPanel() ;
        l4.setLayout(new FlowLayout(FlowLayout.LEFT));
        l4.add(remove) ;
        remove.setEnabled(false);

        //add all group to card
        card.add(l1) ;
        card.add(l2) ;
        card.add(l3) ;
        card.add(l4) ;

        card.add(Box.createVerticalStrut(Short.MAX_VALUE)) ;

        search.addActionListener(this);
        remove.addActionListener(this);
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            if(App.checkPlayer(nameInput.getText())){
                remove.setEnabled(true);
                result.setForeground(Color.BLACK);
                result.setText(App.readPlayers(nameInput.getText()));
            }else{
                remove.setEnabled(false);
                result.setForeground(Color.RED);
                result.setText("Player not existed!\n\n\n\n");
            }
        }else if(e.getSource() == remove){
            App.removePlayer(nameInput.getText());
            remove.setEnabled(false);
            result.setForeground(Color.GREEN);
            result.setText("Player record successfully deleted!\n\n\n\n");
        }
        
    }
}
