import java.awt.event.*;  
import javax.swing.*;

public class InTeRfAcCiA extends JFrame{
    //qualcuno dovrà pur farlo...
    private JButton invia;
    private JButton home;
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
        bergamo = new Sistema("Bergamo",100,100);
        bergamo.createBicis(40);
        bergamo.createRacks(4,10);
        bergamo.assegnaBici();
        init();
    }

    public void init(){
        setLayout(null);
        setSize(1000,800);
        
        invia.setSize(100,25);
        invia.setLocation(0,625);
        invia.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
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
        
        info.setSize(200,100);
        info.setLocation(400,10);
        
        cerca.setSize(200,25);
        cerca.setLocation(10,100);
        
        add(cerca);
        add(info);
        add(invia);
        add(home);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
