package Tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Utils {

    private static Scanner sc = new Scanner(System.in);
    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public static Date getDate() {
        boolean check = false;
        Date d = null;
        do {
            try {
                String strExdate = getString("Date[dd/mm/yy]:", "Date is empty! Try Again!");
                df.setLenient(false); 
                d = df.parse(strExdate);                
                check = true;
            } catch (ParseException e) {
                System.out.println("Invalid Date! Try again.");
                check = false;
            }
        } while (check == false);
        return d;
    }
 
    public static int getInt(String inputMsg, String errorMsg) {
        int n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }


    public static double getDouble(String inputMsg, String errorMsg) {
        double n;
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }


    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }


    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            if (id.length() == 0 || id.isEmpty()) {
                System.out.println(errorMsg);
            } else {
                return id;
            }
        }
    }


    public static void printTF(boolean check, String trueMessage,String falseMessage) {
        if (check) {
            System.out.println(trueMessage);
        } else {
            System.out.println(falseMessage);
        }
    }

    public static String updateString(String messageString,String oldValue){
            String result = oldValue; 
            System.out.println(messageString);
            String newValue = sc.nextLine().trim();
            if (newValue.isEmpty() || newValue.length() == 0){
                return result;
            } else {
                return newValue;
            }
    }
}
