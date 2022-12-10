public class Sistema {
    private Bici[] bici;
    private Noleggio[] noleggi;
    private SmartCard[] sm;
    private Rack[] racks;
    private String comune;
    private int biciTot,rackTot;
    private int biciNow = 0,rackNow = 0;

    public Sistema(String comune,int biciTot, int rackTot){ //biciTot indica quanti bici può avere al massimo il comune
        this.biciTot = biciTot;                             //rackTot indica quante rack può avere al massimo il comune
        this.rackTot = rackTot;
        bici =  new Bici[biciTot];
        noleggi = new Noleggio[1000];
        sm = new SmartCard[1000];
        racks = new Rack[rackTot];
        this.comune = comune;
    }

    public void riportaBici(){//addBici
        //aggiorno il noleggio
        //aggiorno il rack
    }
    public void addSM(){
        //crea una smartcard
    }
    public void prendiBici(){//addNoleggio
        //crea un oggetto noleggio
        //aggiorno il rack
    }
    public void addRack(){
        //serve al sistema per aggiungere racks
    }
    public void ricaricaSM(int importo, SmartCard sm){
        //aggiorna credito Sm
    }
    public void chechValidity(){}
    public void createBicis(Bici[] b, int totB){
        for(int i = biciNow; i<totB; i++){
            b[i] = new Bici("b"+biciNow);
            biciNow++;
        }
    }
    public void createRacks(Rack[] r, int totR,int totP){
        for(int i = rackNow; i<totR; i++){
            r[i] = new Rack("R"+rackNow,totP);
            rackNow++;
        }
    }
}
