public class Sistema {
    private Bici[] bici;
    private Noleggio[] noleggi;
    private SmartCard[] sm;
    private Rack[] racks;
    private String comune;
    private int biciTot,rackTot;
    private int biciNow = 1,rackNow = 1,noleggiNow = 1;

    public Sistema(String comune,int biciTot, int rackTot){ //biciTot indica quanti bici può avere al massimo il comune
        this.biciTot = biciTot;                             //rackTot indica quante rack può avere al massimo il comune
        this.rackTot = rackTot;
        bici =  new Bici[biciTot];
        noleggi = new Noleggio[1000];
        sm = new SmartCard[1000];
        racks = new Rack[rackTot];
        this.comune = comune;
    }

    public void prendiBici(SmartCard sm, int g, int m, int a, Bici b, Rack r,int postoPreso){//addNoleggio
        if(checkValidity(sm)){
            //crea un oggetto noleggio
            Noleggio n = new Noleggio(g, m, a, b, sm, r);
            noleggi[noleggiNow] = n;
            noleggiNow++;
            //aggiorno il rack
            r.delBike(postoPreso);
            b.setStazione(null);
        }
    }
    public void riportaBici(int g,int m,int a,Noleggio n, Rack r, Bici b,int postoOccupato){//addBici
        //aggiorno il noleggio
        n.setEndDate(g,m,a);
        //aggiorno il rack
        r.addBike(postoOccupato, b);
        b.setStazione(r.getCodice());
    }
    public void addSM(){
        //crea una smartcard
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
    public boolean checkValidity(SmartCard sm){
        //controlla che sm non sia scaduta
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
            racks[i] = new Rack("R"+rackNow,totP);
            rackNow++;
        }
    }
    public void assegnaBici(){//default
        for(int i = 0; i<rackNow-1;i++){
            for(int j = 0; j<biciNow/rackNow-1; j++){
                racks[i].addBike(j, bici[j]);
                bici[j].setStazione(racks[i].getCodice());;
            }
        }
    }
    public String cercaBici(String targa){
        for(int i = 0; i<biciNow-1; i++){
            if(bici[i].getTarga().equals(targa)){
                String trovata = "targa:" + bici[i].getTarga() + "\nstazione:" +bici[i].getStazione();
                return trovata;
            }
        }
        return "bici " + targa + " not found";
    }
}
