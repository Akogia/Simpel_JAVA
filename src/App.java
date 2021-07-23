public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // create new Client with name and address
        Client client1 = new Client();
        client1.name = "John Johnsson";
        client1.address = "arbitrarystreet 10, 4859 Cool City";

        // create Bill object
        Bill bill1 = new Bill();
        bill1.setDiscount(0);
        bill1.setTax(0.19);
        bill1.setInvoice(client1);
        bill1.addInvoice(5, 20.20);
        bill1.getBillInformation();
    }
}
