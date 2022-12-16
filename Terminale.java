import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Terminale {
    public static void main(String[] args) {
        Sistema bergamo; 
        
        try{

            FileInputStream fileIn = new FileInputStream("db");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
 
            bergamo = (Sistema)(objectIn.readObject());
 
            System.out.println("The Object has been read from the file");
            objectIn.close();

        }catch(Exception e){
            bergamo = new Sistema("Bergamo",100,100);
            bergamo.createBicis(40);
            bergamo.createRacks(4,10);
            bergamo.assegnaBici();
        }
        Home h = new Home(bergamo);
        Bici[] b = bergamo.notUsed();
        for(int i = 0; i<1000; i++){
            if(b[i] != null){
                System.out.println(b[i].getTarga());
            }
        }
        /*System.out.println(bergamo.cercaBici("b1"));
        System.out.println(bergamo.cercaBici("b100"));
        bergamo.addSM("paolo", 10, 12, 2022, 10000);
        System.out.println(bergamo.cercaSm("paolo"));
        SmartCard miaCarta = bergamo.getSm(0);
        bergamo.prendiBici(miaCarta, 10, 12, 2022, bergamo.getBici(2), bergamo.getRack(0), 1);
        System.out.println(bergamo.getRack(0).getBikes()[0].getTarga());*/
    }   
}