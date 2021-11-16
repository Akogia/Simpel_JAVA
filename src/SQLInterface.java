import java.io.RandomAccessFile;
import java.sql.*;

public class SQLInterface {
    private static String pw;
    private static Connection conn = null;
    private static int id = 3;
    private static Statement stmt = null;
    
    /** 
     * @return Connection
     * @throws Exception
     */
    /*
    This method connects to MySQL Server and uses 'mydatabase'. This following script describes the created table:
    CREATE TABLE `customer` (
    `ID` int NOT NULL,
    `Name` varchar(45) DEFAULT NULL,
    `Address` tinytext,
    PRIMARY KEY (`ID`)
    )
    */
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

            conn = (Connection) DriverManager.getConnection(url, name, pw);
            stmt = (Statement) conn.createStatement();
            System.out.println("Connected");
            return conn;
        } catch (Exception e){System.out.println(e);}
        return null;
    }

    
    /** This method writes clients data into the database customer
     * @param clientInput
     * @return String
     * @throws SQLException
     */
    public static String writeIntoDatabase(Client clientInput) throws SQLException {
        String inputText = "INSERT INTO `mydatabase`.`customer` (`ID`, `Name`, `Address`) VALUES ('" +
                            id +
                            "', '" +  clientInput.getName() +
                            "', '"+ clientInput.getAddress()+
                            "');";
        System.out.println(inputText);
        try{
            stmt = (Statement) conn.createStatement();
            stmt.executeUpdate(inputText);
            id++;
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Record is inserted in the table successfully, please check";
    }

    public static void readFromDatabase(Client searchClient) throws SQLException {
        String query = "SELECT * FROM `mydatabase`.`customer` WHERE Name = '" + searchClient.getName() + "';";
        try{
            ResultSet clientData = stmt.executeQuery(query);
            while (clientData.next()) {
                System.out.println(clientData.getString(1) + ", " + clientData.getString(2) + ", "
                    + clientData.getString(3));
          
              }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
