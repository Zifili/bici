public class Terminale {
    public static void main(String[] args) {
        Sistema bergamo = new Sistema("Bergamo",100,100);
        bergamo.createBicis(40);
        bergamo.createRacks(4,10);
        bergamo.assegnaBici();
        System.out.println(bergamo.cercaBici("b1"));
        System.out.println(bergamo.cercaBici("b100"));
        bergamo.addSM("paolo", 10, 12, 2022, 10000);
        System.out.println(bergamo.cercaSm("paolo"));
        SmartCard miaCarta = bergamo.getSm(0);
        bergamo.prendiBici(miaCarta, 10, 12, 2022, bergamo.getBici(2), bergamo.getRack(0), 1);
    }
}