package db_stuff;

import java.sql.*;

public class DBConnection {

    public Connection getConnection() {

        Connection con = null;

        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sys?useSSL=false&serverTimezone=UTC", "root",
                    "password");
            // MySQL: "jdbc:mysql://hostname:port/databaseName", "username", "password"
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    //RETURN ALL USER INFORMATION FROM DB (first & last name only)
    public void getAllUserInfo() {

        Connection con = getConnection();

        try {
            Statement st = con.createStatement();
            ResultSet rset = st.executeQuery("SELECT * FROM USERS");

            while(rset.next()) {
                String user = rset.getString("username");
                String firstname = rset.getString("first_name");
                String lastname = rset.getString("last_name");

                System.out.println(user + " = " + firstname.substring(0,1).toUpperCase() + firstname.substring(1)
                        + " " + lastname.substring(0,1).toUpperCase() + lastname.substring(1));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ADD A NEW DB USER
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
            System.out.println("User may have been added to db already, there may be a duplicate");
            e.printStackTrace();
        }
    }

    //LOOKUP A USER BASED ON THEIR UNIQUE ID
    public void findUserWithId(int id) {
        Connection con = getConnection();

        try {

            PreparedStatement ps = con.prepareStatement("SELECT first_name, last_name from USERS where user_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                //Formatting strings
                String firstname =  rs.getString("first_name").substring(0,1).toUpperCase()
                        + rs.getString("first_name").substring(1);
                String lastname =  rs.getString("last_name").substring(0,1).toUpperCase()
                        + rs.getString("last_name").substring(1);

                System.out.println("User found!");
                System.out.println("Full Name: " + firstname + " " + lastname);
            }
            else {
                System.out.println("User with ID=" + id + " cannot be found in DB.");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //DELETE A USER FROM DB BASED ON ID
    public void deleteUser(int id) {
        Connection con = getConnection();

        try {

            PreparedStatement ps = con.prepareStatement("DELETE from USERS where user_id=?");
            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if(i != 0) {
                System.out.println("Delete success.");
            }
            else {
                System.out.println("Delete failed.");
            }
        }
        catch(Exception e) {
            System.out.println("User may not exist in the DB.");
            e.printStackTrace();
        }
    }

    //UPDATE USERS USERNAME BASED

    public void updateUsername(int id, String newUsername) {

        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE USERS set username=? WHERE user_id=?");
            ps.setString(1, newUsername);
            ps.setInt(2, id);

            int i = ps.executeUpdate();

            if(i != 0) {
                System.out.println("Updated username successfully.");
            }
            else {
                System.out.println("Could not update username.");
            }
        }
        catch(Exception e ) {
            e.printStackTrace();
        }
    }


}
