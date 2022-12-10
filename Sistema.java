import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Sistema {
    private Bici[] bici;
    private Noleggio[] noleggi;
    private SmartCard[] sm;
    private Rack[] racks;
    private String comune;
    private int biciTot,rackTot;
    private int biciNow = 0,rackNow = 0,noleggiNow = 0,SMNow=0;

    public Sistema(String comune,int biciTot, int rackTot){ //biciTot indica quanti bici può avere al massimo il comune
        this.biciTot = biciTot;                             //rackTot indica quante rack può avere al massimo il comune
        this.rackTot = rackTot;
        bici =  new Bici[this.biciTot];
        noleggi = new Noleggio[1000];
        sm = new SmartCard[1000];
        racks = new Rack[this.rackTot];
        this.comune = comune;
    }
    public void prendiBici(SmartCard sm, int g, int m, int a, Bici b, Rack r,int postoPreso){//addNoleggio
        if(checkValidity(sm) && Arrays.asList(r.getBikes()).contains(b)){
            //crea un oggetto noleggio
            Noleggio n = new Noleggio(g, m, a, b, sm, r);
            noleggi[noleggiNow] = n;
            noleggiNow++;
            //aggiorno il rack
            
            
            
            r.delBike(Arrays.asList(r.getBikes()).indexOf(b)); // b == r.getBikes()[i]
            //Arrays.asList(r.getBikes()).remove(b);
            
            
            
            b.setStazione(null);
            System.out.println("bici "+b.getTarga()+" presa alla stazione "+r.getCodice()+" in data "+g+"/"+m+"/"+a);
        }
    }
    public void riportaBici(int g,int m,int a,Noleggio n, Rack r, Bici b,int postoOccupato){//addBici
        if(r.getBikes()[postoOccupato] != null || postoOccupato < 0 || postoOccupato > r.getBikes().length){
            for(int i = 0; i < r.getBikes().length; i++){
                if(r.getBikes()[i] == null){
                    postoOccupato = i;
                    break;
                }
            }
            System.out.println("rastrelliera piena!");
        } else {
            //aggiorno il noleggio
            n.setEndDate(g,m,a);
            //aggiorno il rack
            r.addBike(postoOccupato, b);
            b.setStazione(r.getCodice());
            System.out.println("bici "+b.getTarga()+" riportata alla stazione "+r.getCodice()+" in data "+g+"/"+m+"/"+a);
        }
    }
    public void addSM(String nome,int g,int m,int a,int credito){
        //crea una smartcard
        sm[SMNow] = new SmartCard(SMNow,g,m,a,credito,nome);
        System.out.println(sm[SMNow].getCodice());
        SMNow++;
    }
    public void addRack(int posti,int nRack){
        //serve al sistema per aggiungere racks
        for(int i = 0; i<nRack; i++){
            racks[rackNow] = new Rack("R"+rackNow, posti);
            rackNow++;
        }
    }
    public void addBici(int nBici){
        for(int i = 0; i<nBici; i++){
            bici[biciNow] = new Bici("b"+rackNow,null);
            biciNow++;
        }
    }
    public void ricaricaSM(int importo, SmartCard sm){
        //aggiorna credito Sm
        
    }
    public long getDate(int g,int m,int a){
        GregorianCalendar data1 = new GregorianCalendar(a, m, g);
        return data1.getTimeInMillis();
    }
    public boolean checkValidity(SmartCard sm){
        //controlla che sm non sia scaduta
        GregorianCalendar ora = new GregorianCalendar();
        int anno = ora.get(Calendar.YEAR);
        int mese = ora.get (Calendar.MONTH)+1;
        int giorno = ora.get (Calendar.DATE);
        long oggi = getDate(giorno,mese,anno);
        GregorianCalendar scadenza = sm.getAttivazione();
        int a = scadenza.get(Calendar.YEAR);
        int m = scadenza.get (Calendar.MONTH)+1;
        int g = scadenza.get (Calendar.DATE);
        long scad = getDate(g,m,a);

        if((scad - oggi) <= 0){
            System.out.println("SmartCard n "+sm.getCodice()+" scaduta");
            return false;
        }
        return true;
    }
    public void createBicis(int totB){
        for(int i = 0;  i<totB; i++){
            bici[i] = new Bici("b"+biciNow,null);
            biciNow++;
        }
    }
    public void createRacks(int totR,int totP){
        for(int i = 0; i<totR; i++){
            racks[rackNow] = new Rack("R"+rackNow,totP);
            rackNow++;
        }
    }
    public void assegnaBici(){//default
        for(int i = 0; i<rackNow;i++){
            for(int j = 0; j<biciNow/rackNow; j++){
                racks[i].addBike(j, bici[j]);
                bici[j].setStazione(racks[i].getCodice());;
            }
        }
    }
    public String cercaBici(String targa){
        for(int i = 0; i<biciNow; i++){
            if(bici[i].getTarga().equals(targa)){
                String trovata = "targa:" + bici[i].getTarga() + "\nstazione:" +bici[i].getStazione() + "\ncomune " + comune;
                return trovata;
            }
        }
        return "bici " + targa + " not found";
    }
    public Bici getBici(int i){
        return bici[i];
    }
    public SmartCard getSm(int i) {
        return sm[i];
    }
    public Rack getRack(int i) {
        return racks[i];
    }
    public String cercaSm(String nome){//, int g,int m, int a){
        for(int i = 0; i<SMNow; i++){
            if(sm[i].getNominativo().equals(nome)){
                String trovata = "nome: " + sm[i].getNominativo() + "\ncomune: " + comune + "\ncodice: " + sm[i].getCodice();
                return trovata;
            }
        }
        return "SmartCard di " + nome + " not found";
    }
}