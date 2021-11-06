import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;

public class App {

        public static String pw;
    public static void main(String[] args) throws Exception {
        getConnection();


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

        // create new invoice object with article1 and desired number of times of the article
        Invoice invoice1 = new Invoice(4, article1);
        bill1.addInvoice(invoice1);

        // create second invoice object for second article 5 times
        Invoice invoice2 = new Invoice(5, article2);
        // add invoice to total amount
        bill1.addInvoice(invoice2);

        // get bill information
        bill1.getBillInformation();


    }




    public static Connection getConnection() throws Exception {
        // reads the password from config.txt file. This file is ignored by git
        try{
                RandomAccessFile raf = new RandomAccessFile("config.txt", "r");
                pw = raf.readLine();
        } catch (Exception e){
                    System.out.println(e);
        }

        // build up the connection to mySQL server for the created database 'mydatabase'
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String name = "root";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, name, pw);
            System.out.println("Connected");
            return conn;
        } catch (Exception e){System.out.println(e);}
        return null;
    }

}
