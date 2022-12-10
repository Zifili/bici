import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;

public class Home extends JFrame {
    private JButton creaCard;
    private JButton creaComune;
    private JLabel titolo;

    public Home(){
        creaCard = new JButton("Crea la tua SmartCard");
        creaComune = new JButton("Configura il tuo comune");
        titolo = new JLabel("RASTRELLIERATOR-3000");
        init();
    }

    public void init(){
        setLayout(null);
        setSize(300,300);
        
        ActionListener carta = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                InTeRfAcCiA i = new InTeRfAcCiA();
                i.setVisible(true);
            }
        };
        creaCard.setSize(200,50);
        creaCard.setLocation(45,100);
        creaCard.addActionListener(carta);

        ActionListener comune = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                Comune c = new Comune();
                c.setVisible(true);
            }
        };
        creaComune.setSize(200,50);
        creaComune.setLocation(45,160);
        creaComune.addActionListener(comune);

        titolo.setSize(200,100);
        titolo.setLocation(70,10);
        
        add(creaCard);
        add(creaComune);
        add(titolo);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}