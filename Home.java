import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Home extends JFrame {
    private JButton creaCard;
    private JButton creaComune;
    private JButton salva;
    private JLabel titolo;
    Sistema sys;
    public Home(Sistema s){
        sys = s;
        creaCard = new JButton("Crea la tua SmartCard");
        creaComune = new JButton("Configura il tuo comune");
        titolo = new JLabel("RASTRELLIERATOR-3000");
        salva = new JButton("salva");
        init();
    }

    public void init(){
        setLayout(null);
        setSize(300,300);
        setResizable(false);
        getContentPane().setBackground(Color.decode("#95A3B3"));
        setTitle("HOME");
        
        ActionListener carta = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                //todo
                InTeRfAcCiA i = new InTeRfAcCiA(sys);
                i.setVisible(true);
            }
        };
        creaCard.setSize(200,50);
        creaCard.setLocation(45,100);

        creaCard.setBorderPainted(false);
        creaCard.setBackground(Color.decode("#222222"));
        creaCard.setForeground(Color.decode("#FFFFFF"));
        creaCard.setFocusPainted(false);
        creaCard.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                creaCard.setBackground(Color.decode("#1098F7"));
                creaCard.setForeground(Color.decode("#222222"));
                creaCard.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //startButton.setBackground(UIManager.getColor("control"));
                creaCard.setBackground(Color.decode("#222222"));
                creaCard.setForeground(Color.decode("#FFFFFF"));
                creaCard.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

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

        creaComune.setBorderPainted(false);
        creaComune.setBackground(Color.decode("#222222"));
        creaComune.setForeground(Color.decode("#FFFFFF"));
        creaComune.setFocusPainted(false);
        creaComune.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                creaComune.setBackground(Color.decode("#1098F7"));
                creaComune.setForeground(Color.decode("#222222"));
                creaComune.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //startButton.setBackground(UIManager.getColor("control"));
                creaComune.setBackground(Color.decode("#222222"));
                creaComune.setForeground(Color.decode("#FFFFFF"));
                creaComune.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        creaComune.addActionListener(comune);

        titolo.setSize(200,100);
        titolo.setLocation(70,10);
        titolo.setForeground(Color.decode("#222222"));

        salva.setSize(75,25);
        salva.setLocation(100,225);
        salva.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
 
                    FileOutputStream fileOut = new FileOutputStream("db");
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(sys);
                    objectOut.close();
                    System.out.println("The Object  was succesfully written to a file");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        
        add(salva);
        add(creaCard);
        add(creaComune);
        add(titolo);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}