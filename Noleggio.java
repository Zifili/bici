import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Noleggio implements Serializable{
    private GregorianCalendar initDate,endDate;
    private String targa;
    private SmartCard SM;
    private String initSt,endSt;
    private String giorno;

    public Noleggio( int g,int m,int a ,Bici bici,SmartCard SM,Rack initSt){
        initDate = new GregorianCalendar(a,m,g);
        targa = bici.getTarga();
        giorno = String.valueOf(initDate.get(Calendar.DAY_OF_WEEK));
        this.SM = SM;
        this.initSt = initSt.getCodice();
    }
    public void setEndSt(String endSt){
        //check if endSt exists
        this.endSt = endSt;
    }
    public GregorianCalendar getEndDate(){
        return endDate;
    }
    public boolean isNoleggiata(Bici b){
        if(b.getTarga().equals(targa)){
            return true;
        }
        return false;
    }
    public void setEndDate(int g, int m, int a){
        //check if endDate is a valid date
        endDate = new GregorianCalendar(a,m,g);
    }
    public String getTarga() {
        return targa;
    }
    public SmartCard getSM() {
        return SM;
    }
    public GregorianCalendar getInitDate() {
        return initDate;
    }
    public String getGiorno() {
        return giorno;
    }
    public String getInitSt() {
        return initSt;
    }public String getEndSt() {
        return endSt;
    }
}
