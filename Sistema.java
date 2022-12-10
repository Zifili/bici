public class Sistema {
    private Bici[] bici;
    private Noleggio[] noleggi;
    private SmartCard[] sm;
    private Rack[] racks;
    private String comune;

    public Sistema(String comune){
        bici =  new Bici[100];
        noleggi = new Noleggio[100];
        sm = new SmartCard[100];
        racks = new Rack[100];
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

}
