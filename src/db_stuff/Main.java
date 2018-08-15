package db_stuff;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        DBUser andy = new DBUser(12345, "asek", "Andy", "Sekulovski", "Male", "password");

//        db.getAllUserInfo();

        db.addNewUser(andy);

        db.getAllUserInfo();

    }

}
