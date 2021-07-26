public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // create new Client with name and address
        Client client1 = new Client("John Johnsson","arbitrarystreet 10, 4859 Cool City");

        // create Bill object
        Bill bill1 = new Bill(client1);
        // no discount --> 0%
        bill1.setDiscount(0);
        // client 1 set for the bill
        bill1.setInvoice(client1);

        // create new article object article number, description, price and the corresponding tax
        Article article1 = new Article(11354225,"this is the first article", 0.50, 0.19);
        // create second article object with price of 1$
        Article article2 = new Article(2554548, "this is the second article", 1, 0.19);

        // create new invoice object with article1 and desired number of times of the articel
        Invoice invoice1 = new Invoice(4, article1);
        bill1.addInvoice(invoice1);

        // create second invoice object for second article 5 times
        Invoice invoice2 = new Invoice(5, article2);
        // add invoice to total amount
        bill1.addInvoice(invoice2);

        // get bill information
        bill1.getBillInformation();
    }
}
