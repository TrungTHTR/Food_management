package Tools;

import java.util.Scanner;

public class Test {
/*
   #################################################################
#                             _`				#
#                          _ooOoo_				#
#                         o8888888o				#
#                         88" . "88				#
#                         (| -_- |)				#
#                         O\  =  /O				#
#                      ____/`---'\____				#
#                    .'  \\|     |//  `.			#
#                   /  \\|||  :  |||//  \			#
#                  /  _||||| -:- |||||_  \			#
#                  |   | \\\  -  /'| |   |			#
#                  | \_|  `\`---'//  |_/ |			#
#                  \  .-\__ `-. -'__/-.  /			#
#                ___`. .'  /--.--\  `. .'___			#
#             ."" '<  `.___\_<|>_/___.' _> \"".			#
#            | | :  `- \`. ;`. _/; .'/ /  .' ; |		#
#            \  \ `-.   \_\_`. _.'_/_/  -' _.' /		#
#=============`-.`___`-.__\ \___  /__.-'_.'_.-'=================#
                           `=--=-'                    

// Nam mô a di dà Phật, source code này chạy không bao giờ có bug // 

          _.-/`)
         // / / )
      .=// / / / )
     //`/ / / / /
    // /     ` /
   ||         /
    \\       /
     ))    .'
    //    /
         /
    
    */
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        F_List list = new Manage();
        int choice;
        do {
            System.out.println("//=======MENU=======\\");
            System.out.println("0.Create Data!!");
            System.out.println("1. Add a food to the list");
            System.out.println("2. Search the food by name");
            System.out.println("3. Remove the food by ID");
            System.out.println("4. Print the food");
            System.out.println("5. Store the food list to binary file");
            System.out.println("6.Quit!");
            System.out.println("7.Remove by Weight");
            choice = Utils.getInt("Input Your Choice: ", "TRY AGAIN!");
            switch (choice) {
                case 0:
                    list.createData();
                    break;
                case 1:
                    list.add();
                    break;
                case 2:
                    list.search();
                    break;
                case 3:
                    list.remove();
                    break;
                case 4:
                    list.printTheFood();
                    break;
                case 5:
                    list.storeTheFoodtoBinary();
                    break;
                case 6: 
                    System.out.println("THANKS FOR USING!");
                    break;
                case 7: 
                    list.removeByWeight();
                    break;
                default:
                    System.out.println("WRONG INPUT!");
                    break;
            }
        } while (choice != 6);
    }

}
