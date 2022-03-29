import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tab1 implements ActionListener{
    //card layout for tab 1
    private JPanel card = new JPanel() ;
    //components for the first tab
    private JLabel heading = new JLabel("Creating new player:") ;
    private JLabel nameInputLabel = new JLabel("Name:") ;
    private JTextField nameInput = new JTextField(10) ;
    private JLabel pointInputLabel = new JLabel("Points:") ;
    private JTextField pointInput = new JTextField(10) ;
    private JButton clearField = new JButton("Reset") ;
    private JButton submit = new JButton("Create") ;
    private JLabel createStatus = new JLabel(" ") ;

    public Tab1(){
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        //group line 1
        JPanel l1 = new JPanel() ;
        l1.setLayout(new FlowLayout(FlowLayout.LEFT));
        l1.add(heading);

        //group line 2
        JPanel l2 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l2.add(nameInputLabel) ;
        l2.add(nameInput) ;

        //group line 3
        JPanel l3 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l3.add(pointInputLabel) ;
        l3.add(pointInput) ;

        //group line 4
        JPanel l4 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l4.add(clearField) ;
        l4.add(submit) ;

        //group line 5
        JPanel l5 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l5.add(createStatus) ;

        //add all group to card
        card.add(l1) ;
        card.add(l2) ;
        card.add(l3) ;
        card.add(l4) ;
        card.add(l5) ;

        card.add(Box.createVerticalStrut(Short.MAX_VALUE)) ;

        clearField.addActionListener(this);
        submit.addActionListener(this);
    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clearField){
            nameInput.setText("");
            pointInput.setText("");
        }else if(e.getSource() == submit){
            if(App.checkPlayer(nameInput.getText())){
                createStatus.setForeground(Color.RED);
                createStatus.setText("Username already used!");
            }else{
                App.createPlayer(new Player(nameInput.getText(), Integer.parseInt(pointInput.getText())));
                createStatus.setForeground(Color.GREEN);
                createStatus.setText("New player record created!");
            }
        }
        
    }
}
