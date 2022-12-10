public class Terminale {
    public static void main(String[] args) {
        Sistema bergamo = new Sistema("Bergamo",100,100);
        Bici[] bigi = new Bici[100];
        Rack[] biri = new Rack[100];
        bergamo.createBicis(bigi, 40);
        bergamo.createRacks(biri, 4,10);
    }
}
