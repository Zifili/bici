import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;

public class Comune extends JFrame{
    private JButton home;
    private ImageIcon i;
    private Sistema bergamo;
    private JButton invia;
    private JTextField cerca;
    private JLabel info;
    
    public Comune(){
        i = new ImageIcon("img/home.png");
        invia = new JButton("invio");
        cerca = new JTextField("cerca...");
        info = new JLabel("RASTRELLIERATOR-3000");
        home = new JButton(i);
        bergamo = new Sistema("Bergamo",100,100);
        bergamo.createBicis(40);
        bergamo.createRacks(4,10);
        bergamo.assegnaBici();
        init();
    }

    public void init(){
        setLayout(null);
        setSize(300,300);

        home.setSize(30,30);
        home.setLocation(10,10);
        home.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    dispose();
                    Home h = new Home();
                    h.setVisible(true);
                }
            }    
        );

        invia.setSize(70,25);
        invia.setLocation(210,100);
        invia.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String ricerca = cerca.getText();
                if(ricerca.charAt(0) == 'b')
                    JOptionPane.showMessageDialog(null,bergamo.cercaBici(ricerca));
                else
                    JOptionPane.showMessageDialog(null,bergamo.cercaSm(ricerca));
            }
        }    
        );

        cerca.setSize(200,25);
        cerca.setLocation(10,100);
        cerca.setForeground(Color.GRAY);
        cerca.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (cerca.getText().equals("cerca...")){
                    cerca.setText("");
                    cerca.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e){
                if (cerca.getText().isEmpty()) {
                    cerca.setForeground(Color.GRAY);
                    cerca.setText("cerca...");
                }
            }
            });

        info.setSize(200,100);
        info.setLocation(60,10);
        
        add(info);
        add(home);
        add(cerca);
        add(invia);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
