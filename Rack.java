public class Rack{
    private String codice;
    private Bici[] bikes;
    private int totPosti;
    private int liberi;

    Rack(String codice, int totPosti) {
        this.codice = codice;
        this.totPosti = totPosti;
        liberi = totPosti;
        bikes = new Bici[totPosti];
    }

    public String getCodice() {
        return codice;
    }

    public int getTotPosti() {
        return totPosti;
    }

    public int getLiberi() {
        return liberi;
    }

    public Bici[] getBikes() {
        return bikes;
    }

    public void addBike(int posto, Bici bike) {
        bikes[posto] = bike;
    }

    public void delBike(int posto) {
        bikes[posto] = null;
    }
}