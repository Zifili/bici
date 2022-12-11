import java.awt.event.*;  
import javax.swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
//import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class InTeRfAcCiA extends JFrame{
    //qualcuno dovrà pur farlo...
    private JButton invia;
    private JButton home;
    private JButton creaSm;
    private JButton noleggia;
    private ImageIcon i;
    private JLabel info;
    private JTextField cerca;
    private JTextField nome;
    private Sistema bergamo;
    public InTeRfAcCiA(){
        i = new ImageIcon("img/home.png");
        invia = new JButton("Cerca");
        home = new JButton(i);
        creaSm = new JButton("Crea una SmartCard");
        noleggia = new JButton("noleggia una bici");
        info = new JLabel("RASTRELLIERATOR-3000");
        cerca = new JTextField("Cerca bici...");
        nome = new JTextField("Inserisci il tuo nome...");
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
        setTitle("CREA SMARTCARD");

        
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

        Font fieldFont = new Font("Arial", Font.PLAIN, 14);
        cerca.setFont(fieldFont);
        cerca.setBackground(Color.decode("#222222"));
        cerca.setForeground(Color.decode("#FFFFFF"));
        cerca.setCaretColor(Color.decode("#FFFFFF")); // modifica l'icona lampeggiante quando selezioni il testo
        cerca.setBorder(new LineBorder(Color.decode("#222222"),1));

        cerca.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (cerca.getText().equals("Cerca bici...")){
                    cerca.setText("");
                    cerca.setForeground(Color.decode("#FFFFFF"));
                }
            }
            public void focusLost(FocusEvent e){
                if (cerca.getText().isEmpty()) {
                    cerca.setForeground(Color.decode("#FFFFFF"));
                    cerca.setText("Cerca bici...");
                }
            }
            });
        
        creaSm.setSize(200,50);
        creaSm.setLocation(40,200);

        creaSm.setBorderPainted(false);
        creaSm.setBackground(Color.decode("#222222"));
        creaSm.setForeground(Color.decode("#FFFFFF"));
        creaSm.setFocusPainted(false);
        creaSm.addMouseListener(new MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                creaSm.setBackground(Color.decode("#1098F7"));
                creaSm.setForeground(Color.decode("#222222"));
                creaSm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                //startButton.setBackground(UIManager.getColor("control"));
                creaSm.setBackground(Color.decode("#222222"));
                creaSm.setForeground(Color.decode("#FFFFFF"));
                creaSm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        creaSm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String nominativo = nome.getText();
                bergamo.addSM(nominativo, 100);
                JOptionPane.showMessageDialog(null, "SmartCard creata correttamente","avviso",1);
                int code = bergamo.getSMNow()-1;
                JOptionPane.showMessageDialog(null, "Nome: "+nominativo+"\ncredito:100"+"\ndata creazione:"+bergamo.getSm(code).getAttivazioneData()+"\ncomune: Bergamo\ncodice:"+code,"infocard",1);
                remove(creaSm);
                noleggia.setSize(200,50);
                noleggia.setLocation(40,200);
                noleggia.setBackground(Color.decode("#222222"));
                noleggia.setForeground(Color.decode("#FFFFFF"));
                noleggia.setFocusPainted(false);
                noleggia.addMouseListener(new MouseAdapter() {
                    public void mouseEntered(java.awt.event.MouseEvent evt) {
                        noleggia.setBackground(Color.decode("#1098F7"));
                        noleggia.setForeground(Color.decode("#222222"));
                        noleggia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    }
                    public void mouseExited(java.awt.event.MouseEvent evt) {
                        //startButton.setBackground(UIManager.getColor("control"));
                        noleggia.setBackground(Color.decode("#222222"));
                        noleggia.setForeground(Color.decode("#FFFFFF"));
                        noleggia.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                    }
                });
                noleggia.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String bici = cerca.getText();
                        int b = Character.getNumericValue(bici.charAt(1));
                        int r = Character.getNumericValue((bici.charAt(4)));
                        String out = bergamo.prendiBici(bergamo.getSm(code), 11,12,2022,bergamo.getBici(b),bergamo.getRack(r));
                        JOptionPane.showMessageDialog(null,out);
                    }
                });
                add(noleggia);
            }
        });
        
        nome.setSize(200,25);
        nome.setLocation(10,150);
        nome.setForeground(Color.GRAY);

        Font fieldFont1 = new Font("Arial", Font.PLAIN, 14);
        nome.setFont(fieldFont1);
        nome.setBackground(Color.decode("#222222"));
        nome.setForeground(Color.decode("#FFFFFF"));
        nome.setCaretColor(Color.decode("#FFFFFF")); // modifica l'icona lampeggiante quando selezioni il testo
        nome.setBorder(new LineBorder(Color.decode("#222222"),1));
        
        nome.addFocusListener(new FocusListener(){
            public void focusGained(FocusEvent e){
                if (nome.getText().equals("Inserisci il tuo nome...")){
                    nome.setText("");
                    nome.setForeground(Color.decode("#FFFFFF"));
                }
            }
            public void focusLost(FocusEvent e){
                if (nome.getText().isEmpty()) {
                    nome.setForeground(Color.decode("#FFFFFF"));
                    nome.setText("Inserisci il tuo nome...");
                }
            }
            });
        
        add(nome);
        add(creaSm);
        add(cerca);
        add(info);
        add(invia);
        add(home);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
