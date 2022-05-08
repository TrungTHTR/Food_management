package Tools;

import Food.Food;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.text.ParseException;
import java.io.IOException;

public class Manage extends ArrayList<Food> implements F_List {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Scanner sc = new Scanner(System.in);

    ArrayList<Food> list = new ArrayList<>();

    int choice = 0;
    Food fd = null;
    int index = -1;
    String id = "";
    String name = "";
    boolean check = false;
    double weight = 0;

    public ArrayList<Food> listFoundByName(ArrayList<Food> lf, String keyword) {
        ArrayList<Food> listfoundname = new ArrayList<Food>();
        for (Food fd : lf) {
            if (fd.getName().contains(keyword)) {
                listfoundname.add(fd);
            }
        }
        return listfoundname;
    }

    public ArrayList<Food> listFoundByweight(ArrayList<Food> lf, double keyword) {
        ArrayList<Food> listfoundid = new ArrayList<Food>();
        for (Food fd : lf) {
            if (fd.getWeight() == keyword) {
                listfoundid.add(fd);
            }
        }
        return listfoundid;
    }

    @Override
    public void add() {
        do {
            System.out.println("ADD FUNCTION");
            System.out.println("1.Add");
            System.out.println("0.Exit");
            choice = Utils.getInt("Input your Choice: ", "Input Again!");
            switch (choice) {
                case 1:
                    fd = new Food();
                    fd.create();
                    index = list.indexOf(fd);
                    if (list.isEmpty()) {
                        list.add(fd);
                        System.out.println("ADDED SUCCESS");
                    } else {
                        for (Food foodID : list) {
                            if (foodID.getId().equals(fd.getId())) {
                                System.out.println("DUPLICATED!");
                                break;
                            } else {
                                list.add(fd);
                                System.out.println("ADD SUCCESS");
                                break;
                            }
                        }
                    }
                case 0:
                    break;
            }
        } while (choice != 0);
    }

    @Override
    public void createData() {
        df.setLenient(false);
        try {
            list.add(new Food("Xúc Xích", "123", 4.5, "Ăn Liền", "Tầng Dưới", df.parse("22/12/2022")));
            list.add(new Food("RedBull", "456", 2.5, "Nước Uống", "Tầng Dưới", df.parse("20/10/2024")));
            list.add(new Food("Thịt Bò", "6788xx220922", 10, "Tươi Sống", "Tầng Trên", df.parse("22/11/2021")));
            list.add(new Food("Xà Lách", "9875xx159", 1.3, "Tươi Sống", "Tầng Dưới", df.parse("15/11/2021")));
            list.add(new Food("Kem", "357xx159", 6, "Ăn Liền", "Tầng Trên", df.parse("24/12/2023")));
        } catch (ParseException e) {
            System.out.println("INVALID DATE! TRY AGAIN!");
        }
    }

    @Override
    public void search() {
        if (list.isEmpty()) {
            System.out.println("List is Empty!!");
        } else {
            do {
                System.out.println("SEARCH FUNCTION!");
                System.out.println("1.Search");
                System.out.println("2.Exit!");
                choice = Utils.getInt("Input your Choice: ", "Input Again!");
                switch (choice) {
                    case 1:
                        name = Utils.getString("Input Food names you want to find: ", "Input Again!");
                        ArrayList<Food> listfoundbyname = listFoundByName(list, name);
                        if (listfoundbyname.isEmpty()) {
                            System.out.println("FOOD DOES NOT EXIST!");
                        } else {
                            for (Food foodName : listfoundbyname) {
                                fd = foodName;
                                System.out.println(fd.toString());
                            }
                        }
                    case 2:
                        break;
                    default:
                        System.out.println("WRONG INPUT!");
                        break;
                }
            } while (choice != 2);
        }
    }

    @Override
    public void remove() {
        if (list.isEmpty()) {
            System.out.println("List Is Empty!");
        } else {
            System.out.println("Are you sure want to remove ?");
            System.out.println("1.yes");
            System.out.println("2.no");
            choice = Utils.getInt("Input Your Choice:", "Input Again!");
            switch (choice) {
                case 1:
                    id = Utils.getString("Input Food ID that you want to remove: ", "Input Again!");
                    for (Food foodID : list) {
                        if (foodID.getId().equals(id)) {
                            fd = foodID;
                            System.out.println(fd.toString());
                            check = list.remove(fd);
                            Utils.printTF(check, "REMOVE SUCCESS!", "CAN'T REMOVE!");
                            break;
                        }
                    }
                case 2:
                    break;
                default:
                    System.out.println("WRONG INPUT!!");
                    break;
            }
        }
    }

    @Override
    public void printTheFood() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY!!");
        } else {
            Collections.sort(list, new Comparator<Food>() {
                @Override
                public int compare(Food o1, Food o2) {
                    return o2.compareTo(o1);
                }
            });
            for (Food foodList : list) {
                System.out.println(foodList.toString());
            }
        }
    }

    @Override
    public void storeTheFoodtoBinary() {
        do {
            if (list.isEmpty()) {
                System.out.println("LIST IS EMPTY!");
                check = true;
            } else {
                try {
                    String putName = Utils.getString("Input your filename: ", "FileName is empty");
                    String fileName = putName + ".dat";
                    FileWriter fw = new FileWriter(fileName);
                    for (Food f : list) {
                        fw.write(f.toString());
                        fw.write("\n");
                    }
                    System.out.println("SUCCESS!!");
                    fw.close();
                } catch (IOException e) {
                    System.out.println("ERROR!!");
                }
            }
        } while (check = false);
    }

    @Override
    public void removeByWeight() {
        if (list.isEmpty()) {
            System.out.println("List Is Empty!");
        } else {
            System.out.println("Are you sure want to remove ?");
            System.out.println("1.yes");
            System.out.println("2.no");
            choice = Utils.getInt("Input Your Choice:", "Input Again!");
            switch (choice) {
                case 1:
                    weight = Utils.getDouble("Input Food Weight that you want to remove: ", "Input Again!");
                    ArrayList<Food> listfoundbyweight = listFoundByweight(list, weight);
                    if (listfoundbyweight.isEmpty()) {
                        System.out.println("FOOD DOES NOT EXIST!");
                    } else {
                        for (Food foodName : listfoundbyweight) {
                            fd = foodName;
                            check = list.remove(fd);
                            Utils.printTF(check, "Success!!", "CAN'T REMOVE!");
                        }
                    }
                case 2:
                    break;
                default:
                    System.out.println("WRONG INPUT!!");
                    break;
            }
        }
    }
}
