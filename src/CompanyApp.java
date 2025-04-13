package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static src.UI.*;

public class CompanyApp {
    private static Scanner scanner;

    CompanyApp(){
        scanner = new Scanner(System.in);
    }

    private static void start() {
        printMainMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): ordersMenu(); break;
            case("2"): storagesMenu(); break;
            case("3"): salingPointsMenu(); break;
            case("4"): productsMenu(); break;
            case("5"): employeesMenu(); break;
            case("6"): customersMenu(); break;
            default: start();
        }
    }

    private static void storagesMenu() {
        printActionStorageMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): infoMenu(CompanyData.getStorages()); break;
            case("2"): moveMenu(); break;
            case("3"): newObjectMenu(); break;
            case("4"): deleteObjectMenu(); break;
            case("5"): employeesMenu(); break;
            case("6"): customersMenu(); break;
            default: storagesMenu(); break;
        }
    }
    private static void infoMenu(Map<String, ? extends Printable> map){
        printAllOrOneMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): printAllInfo(map.values()); break;
            case("2"):
                printEnterNameMenu();
                in = scanner.nextLine();
                map.get(in).printInfo();
                break;
        }
    }
    private static <T> T getObjectByName(Map<String, T> map) {
        String name = scanner.nextLine();
        while (!map.containsKey(name)) {
            name = scanner.nextLine();
        }

        return map.get(name);
    }

    private static List<Product> getListOfProductsByName(){
        List<Product> listOfProducts = new LinkedList<>();
        boolean flagToContinue = true;
        String name;
        int count;
        while(flagToContinue) {
            printEnterNameMenu("товара и его количество(введите 0 для конца)");
            System.out.println("Список товаров в заказе: ");
            printAllInfo(listOfProducts);
            if (scanner.hasNext()) {
                name = scanner.next();
                if(name.equals("0")){flagToContinue = false;}
                if (scanner.hasNextInt()) {
                    count = scanner.nextInt();
                    Product availableProduct = CompanyData.getProducts().get(name);
                    if(count <= availableProduct.getCount()){
                        listOfProducts.add(availableProduct.copyAndSetCount(count));
                        availableProduct.setCount(availableProduct.getCount() - count);
                    }
                }
            }
            clearConsole();
        }
        return listOfProducts;
    }
    private static void enterButtonToGetBack(){
        scanner.nextLine();
        start();
    }
}
