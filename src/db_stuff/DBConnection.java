package db_stuff;

import java.sql.*;

public class DBConnection {

    public Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC", "root", "password");
            // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void getAllUserInfo() {

        Connection con = getConnection();

        try {
            Statement st = con.createStatement();

            ResultSet rset = st.executeQuery("SELECT * FROM USERS");

            while(rset.next()) {
                String user = rset.getString("username");
                String firstname = rset.getString("first_name");
                String lastname = rset.getString("last_name");

                System.out.println(user + " = " + firstname.substring(0,1).toUpperCase() + firstname.substring(1) + " " + lastname.substring(0,1).toUpperCase() + lastname.substring(1));
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void addNewUser(DBUser u) {

        Connection con = getConnection();

        try {
           PreparedStatement ps =  con.prepareStatement("insert into USERS values(?,?,?,?,?,?,?)");

           ps.setInt(1, u.getId());
           ps.setString(2, u.getUsername());
           ps.setString(3, u.getFirstname());
           ps.setString(4, u.getLastname());
           ps.setString(5, u.getGender());
           ps.setString(6, u.getPassword());
           ps.setInt(7, u.getStatus());

           int i = ps.executeUpdate();

           if(i != 0) {
               System.out.println(u.getFirstname() + " was inserted successfully.");
           }
           else {
               System.out.println("Could not insert properly.");
           }
           
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }


}
