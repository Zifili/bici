import java.util.Date;

public class SmartCard {
    String codice;
    Date attivazione;
    int credito=0;
    String nominativo;

    public SmartCard(String codice, Date attivazione, int credito, String nominativo) {
        this.codice = codice;
        this.attivazione = attivazione;
        this.credito = credito;
        this.nominativo = nominativo;
    }
    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        codice = codice;
    }

    public Date getAttivazione() {
        return attivazione;
    }

    public void setAttivazione(Date attivazione) {
        attivazione = attivazione;
    }

    public int getCredito() {
        return credito;
    }

    public void setCredito(int credito) {
        credito = credito;
    }

    public String getNominativo() {
        return nominativo;
    }

    public void setNominativo(String nominativo) {
        nominativo = nominativo;
    }
}

