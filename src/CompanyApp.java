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
            case("1"): storagesMenu(); break;
            case("2"): salingPointsMenu(); break;
            case("3"): productsMenu(); break;
            case("4"): employeesMenu(); break;
            case("5"): customersMenu(); break;
            default: start();
        }
    }

    private static void storagesMenu() {
        printActionStorageMenu();
        String in = scanner.nextLine();
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
