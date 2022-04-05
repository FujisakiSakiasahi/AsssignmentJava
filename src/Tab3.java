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
    private JLabel winLabel = new JLabel("Win:") ;
    private JTextField winTF = new JTextField(10) ;
    private JLabel loseLabel = new JLabel("Lose:") ;
    private JTextField loseTF = new JTextField(10) ;
    private JLabel WRLabel = new JLabel("Winrate:") ;
    private JTextField WRTF = new JTextField(10) ;
    private JButton reset = new JButton("Reset") ;
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
        
        //group line 4
        JPanel l4 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l4.add(pointInputLabel) ;
        l4.add(pointEditInput) ;

        //group line 5
        JPanel l5 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l5.add(winLabel) ;
        l5.add(winTF) ;

        //group line 6
        JPanel l6 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l6.add(loseLabel) ;
        l6.add(loseTF) ;

        //group line 7
        JPanel l7 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l7.add(WRLabel) ;
        l7.add(WRTF) ;

        //group line 7
        JPanel l8 = new JPanel(new FlowLayout(FlowLayout.LEFT)) ;
        l8.add(reset) ;
        l8.add(submit) ;
        
        //add all group to card
        card.add(l1) ;
        card.add(l2) ;
        card.add(l3) ;
        card.add(l4) ;
        card.add(l5) ;
        card.add(l6) ;
        card.add(l7) ;
        card.add(l8) ;

        card.add(Box.createVerticalStrut(Short.MAX_VALUE)) ;

        search.addActionListener(this);
        reset.addActionListener(this);
        submit.addActionListener(this);

        nameEditInput.setEditable(false);
        pointEditInput.setEditable(false);
        winTF.setEditable(false);
        loseTF.setEditable(false);
        WRTF.setEditable(false);
        reset.setEnabled(false);
        submit.setEnabled(false);

    }

    public JPanel getCard(){
        return card ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == search){
            if(App.checkPlayer(nameInput.getText())){
                nameEditInput.setEditable(true);
                pointEditInput.setEditable(true);
                reset.setEnabled(true);
                submit.setEnabled(true);

                String[] record = App.getPlayer(nameInput.getText()) ;
                nameEditInput.setText(record[0]);
                pointEditInput.setText(record[1]);
                winTF.setText(record[2]);
                loseTF.setText(record[3]);
                WRTF.setText(record[4]);

                nameInput.setEditable(false);
                search.setEnabled(false);
            }else{
                nameEditInput.setEditable(false);
                pointEditInput.setEditable(false);
                reset.setEnabled(false);
                submit.setEnabled(false);
                nameEditInput.setText("");
                pointEditInput.setText("");
                winTF.setText("");
                loseTF.setText("");
                WRTF.setText("");
                JOptionPane.showMessageDialog(null, "Name not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }else if(e.getSource() == reset){
            String[] record = App.getPlayer(nameInput.getText()) ;
            nameEditInput.setText(record[0]);
            pointEditInput.setText(record[1]);
            winTF.setText(record[2]);
            loseTF.setText(record[3]);
            WRTF.setText(record[4]);

        }else if(e.getSource() == submit){
            String[] record = App.getPlayer(nameInput.getText()) ;

            if(record[0].equals(nameEditInput.getText()) || !App.checkPlayer(nameEditInput.getText())){
                if(nameEditInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }else if(pointEditInput.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Points cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    try{
                        App.removePlayer(record[0]);
                        Player newPlayerInfo = new Player(nameEditInput.getText(), Integer.parseInt(pointEditInput.getText())) ;
                        newPlayerInfo.setWL(Integer.parseInt(winTF.getText()), Integer.parseInt(loseTF.getText())) ;
                        App.createPlayer(newPlayerInfo);

                        nameInput.setText("");

                        nameEditInput.setEditable(false);
                        pointEditInput.setEditable(false);
                        reset.setEnabled(false);
                        submit.setEnabled(false);
                        nameEditInput.setText("");
                        pointEditInput.setText("");
                        winTF.setText("");
                        loseTF.setText("");
                        WRTF.setText("");

                        nameInput.setEditable(true);
                        search.setEnabled(true);
                    }catch(NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null, "Wrong input at points input", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "This name is already existed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
