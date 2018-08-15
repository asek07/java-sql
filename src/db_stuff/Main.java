package db_stuff;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        DBConnection db = new DBConnection();

        DBUser andy = new DBUser(12345, "asek", "Andy", "Sekulovski", "Male", "password");

        DBUser mirko = new DBUser(88888, "mirk0", "Mirko", "Pal", "Male", "password");

        db.addNewUser(mirko);

        db.findUserWithId(mirko.getId());

        //db.getAllUserInfo();

       //db.addNewUser(andy);

        db.findUserWithId(andy.getId());

        db.deleteUser(andy.getId());

        db.findUserWithId(andy.getId());

        db.addNewUser(andy);

        db.findUserWithId(andy.getId());

        db.updateUsername(andy.getId(), "asek07");

        db.getAllUserInfo();

    }

}
