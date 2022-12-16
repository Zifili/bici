import java.awt.event.*;  
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.Font;

public class Comune extends JFrame{
    private JButton home;
    private ImageIcon i;
    private Sistema bergamo;
    private JButton invia;
    private JTextField cerca;
    private JLabel info;
    
    public Comune(){
        i = new ImageIcon("img/home.png");
        invia = new JButton("Invio");
        cerca = new JTextField("Cerca...");
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
        setResizable(false);
        getContentPane().setBackground(Color.decode("#95A3B3"));
        setTitle("COMUNE");

        home.setSize(30,30);
        home.setLocation(10,10);
        home.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    dispose();
                    Home h = new Home(bergamo);
                    h.setVisible(true);
                }
            }    
        );

        invia.setSize(70,25);
        invia.setLocation(210,100);

        invia.setBorderPainted(false);
        invia.setBackground(Color.decode("#222222"));
        invia.setForeground(Color.decode("#FFFFFF"));
        invia.setFocusPainted(false);
        invia.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                invia.setBackground(Color.decode("#1098F7"));
                invia.setForeground(Color.decode("#222222"));
                invia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //startButton.setBackground(UIManager.getColor("control"));
                invia.setBackground(Color.decode("#222222"));
                invia.setForeground(Color.decode("#FFFFFF"));
                invia.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        invia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        cerca.setForeground(Color.decode("#4B4E6D"));
        
        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        cerca.setFont(fieldFont);
        cerca.setBackground(Color.decode("#222222"));
        cerca.setForeground(Color.decode("#FFFFFF"));
        cerca.setCaretColor(Color.decode("#FFFFFF")); // modifica l'icona lampeggiante quando selezioni il testo
        cerca.setBorder(new LineBorder(Color.decode("#222222"),1));

        cerca.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e) {
                if (cerca.getText().equals("Cerca...")){
                    cerca.setText("");
                    cerca.setForeground(Color.decode("#FFFFFF"));
                }
            }
            public void focusLost(FocusEvent e) {
                if (cerca.getText().isEmpty()) {
                    cerca.setForeground(Color.decode("#FFFFFF"));
                    cerca.setText("Cerca...");
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
