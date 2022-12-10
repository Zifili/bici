public class Bici{
    private String targa;
    private String stazione;
    public Bici(String targa, String stazione){
        this.targa = targa;
        this.stazione = stazione;
    }

    public String getTarga(){
        return targa;
    }
    public void setStazione(String stazione) {
        this.stazione = stazione;
    }
    public String getStazione() {
        return stazione;
    }
}