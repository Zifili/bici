import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;

public class InTeRfAcCiA extends JFrame{
    //qualcuno dovrà pur farlo...
    private JButton invia;
    private JButton home;
    private JButton creaSm;
    private ImageIcon i;
    private JLabel info;
    private JTextField cerca;
    private Sistema bergamo;
    public InTeRfAcCiA(){
        i = new ImageIcon("img/home.png");
        invia = new JButton("cerca");
        home = new JButton(i);
        info = new JLabel("RASTRELLIERATOR-3000");
        cerca = new JTextField("cerca...");
        creaSm = new JButton("Crea una SmartCard");
        bergamo = new Sistema("Bergamo",100,100);
        bergamo.createBicis(40);
        bergamo.createRacks(4,10);
        bergamo.assegnaBici();
        init();
    }

    public void init(){
        setLayout(null);
        setSize(300,300);
        
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
        
        info.setSize(200,100);
        info.setLocation(60,10);
        
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
        
        creaSm.setSize(200,50);
        creaSm.setLocation(40,150);
        creaSm.setBackground(Color.GREEN);
        
        add(creaSm);
        add(cerca);
        add(info);
        add(invia);
        add(home);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
