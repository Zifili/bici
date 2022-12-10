import java.util.GregorianCalendar;

public class SmartCard {
    
    int codice;
    GregorianCalendar attivazione;
    int credito=0;
    String nominativo;

    public SmartCard(int codice, int g, int m,int a, int credito, String nominativo) {
        this.codice = codice;
        this.attivazione = new GregorianCalendar(a,m,g);
        this.credito = credito;
        this.nominativo = nominativo;
    }
    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public GregorianCalendar getAttivazione() {
        return attivazione;
    }

    public void setAttivazione(GregorianCalendar attivazione) {
        this.attivazione = attivazione;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        this.credito = credito;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }
}

