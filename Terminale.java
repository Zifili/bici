public class Terminale {
    public static void main(String[] args) {
        Sistema bergamo = new Sistema("Bergamo",100,100);
        bergamo.createBicis(40);
        bergamo.createRacks(4,10);
        bergamo.assegnaBici();
        System.out.println(bergamo.cercaBici("b1"));
        System.out.println(bergamo.cercaBici("b100"));
    }
}
