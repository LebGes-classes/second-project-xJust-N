package src;

import java.util.Scanner;
import static src.UI.*;

public class CompanyApp {
    private static Scanner scanner;

    CompanyApp(){
        scanner = new Scanner(System.in);
    }

    public static void start() {
        CompanyData data= CompanyData.load();
        printMainMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): ordersMenu(); break;
            case("2"): storagesMenu(); break;
            case("3"): salingPointsMenu(); break;
            case("4"): productsMenu(); break;
            case("5"): employeesMenu(); break;
            case("6"): customersMenu(); break;
            default:
        }
    }
    public static void ordersMenu() {
        CompanyData data= CompanyData.load();
        printActionOrdersMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"):
                printAllOrOneMenu();
                in = scanner.nextLine();

                switch(in){
                    case("1"): printAllInfo(CompanyData.getOrders()); break;
                    case("2"):
                        printEnterNameMenu();
                        in = scanner.nextLine();
                        printInfo(CompanyData.getOrders().get(in));
                        break;
                }
                break;

            case("2"): storagesMenu(); break;
            case("3"): salingPointsMenu(); break;
            case("4"): productsMenu(); break;
            case("5"): employeesMenu(); break;
            case("6"): customersMenu(); break;
            default:
        }
    }
}
