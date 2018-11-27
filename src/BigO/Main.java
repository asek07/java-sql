package BigO;

import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //reverse a string
        reverseString("The quick brown fox JumPs oVer the yellow dog");
        reverseString("abcdefghijklmnopqrstuvwxyz");
    }

    static void reverseString(String input) {

        String reversedString = "";
        System.out.println("Length of string is: " + input.length());

        for(int i=0; i < input.length(); i++) {
            char found = input.charAt(input.length() - (i+1));

           // System.out.println("letter: " + found);
            reversedString += found;
        }
        System.out.println(input + " >>> " + reversedString.toLowerCase());
    }

    void sortNames(String[] names) {

    }

}
