import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab4 implements ActionListener{
    //card layout for tab 4
    private JPanel card = new JPanel() ;
    private JLabel lblshowplayerinfo = new JLabel("Show Player Info");
    private JLabel lblname = new JLabel("Name:");
    private JTextField txtplayername = new JTextField(10);
    private JTextArea result = new JTextArea(2,1) ;
    private JButton btnsearch = new JButton("search");

    public Tab4(){
        //components for the fouth tab
        btnsearch.addActionListener(this);

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JPanel l1 = new JPanel() ;
        l1.setLayout(new FlowLayout(FlowLayout.LEFT));
        l1.add(lblshowplayerinfo);

        JPanel l2 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l2.add(lblname);
        l2.add(txtplayername);
        l2.add(btnsearch);

        JPanel l3 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        result.setEditable(false);
        result.setText("Player ID: " + "\nPlayer Name: " + "\nPoints: " + "\n");
        l3.add(result);

        card.add(l1);
        card.add(l2);
        card.add(l3);
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnsearch){
            if(App.checkPlayer(txtplayername.getText())){
                result.setText(App.readPlayers(txtplayername.getText()));
            }else{
                result.setForeground(Color.RED);
                result.setText("Player not existed!\n\n\n");
            }
        }
        
    }
}
