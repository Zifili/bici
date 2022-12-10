import java.util.GregorianCalendar;

public class Noleggio {
    private GregorianCalendar initDate,endDate;
    private String targa;
    private SmartCard SM;
    private String initSt,endSt;

    public Noleggio( int g,int m,int a ,Bici bici,SmartCard SM,Rack initSt){
        initDate = new GregorianCalendar(a,m,g);
        targa = bici.getTarga();
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
}
