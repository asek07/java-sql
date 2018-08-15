package DatabaseTesting;
import java.sql.*;


public class DBConnection {


    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC", "root", "password");
            // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

            // Step 2: Allocate a 'Statement' object in the Connection
            Statement stmt = conn.createStatement();

            String strSelect = "select username, first_name, last_name from USERS";
            System.out.println("The SQL query is: " + strSelect); // Echo For debugging
            System.out.println();

            ResultSet rset = stmt.executeQuery(strSelect);

            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            System.out.println("The records selected are:");
            int rowCount = 0;
            while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                String user = rset.getString("username");
                String firstname = rset.getString("first_name");
                String lastname = rset.getString("last_name");

                System.out.println(user + " = " + firstname + " " + lastname.substring(0,1).toUpperCase() + lastname.substring(1));
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
