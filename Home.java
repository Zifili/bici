import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;

public class Home extends JFrame {
    private JButton creaCard;
    private JButton creaComune;

    public Home(){
        creaCard = new JButton("Crea la tua SmartCard");
        creaComune = new JButton("Configura il tuo comune");
        init();
    }

    public void init(){
        setLayout(null);
        setSize(300,300);
        creaCard.setSize(getPreferredSize());
        creaCard.setLocation(getMousePosition());

        creaComune.setSize(getPreferredSize());
        creaComune.setLocation(10,10);
        add(creaCard);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
