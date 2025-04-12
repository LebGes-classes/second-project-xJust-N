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

    private static void ordersMenu() {
        printActionOrdersMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): infoMenu(CompanyData.getOrders()); break;
            case("2"):
                printEnterNameMenu("получателя");
                Customer recipient = getObjectByName(CompanyData.getCustomers());
                printEnterNameMenu("пункта выдачи");
                SalingPoint sp = getObjectByName(CompanyData.getSalingPoints());
                printEnterNameMenu("товара и его количество(введите 0 для конца)");
                List<Product> listOfProducts = getListOfProductsByName();

                Order order = new Order(recipient, listOfProducts, sp);
                CompanyData.add(order);
                order.printInfo();

                enterButtonToGetBack();
                break;

            case("3"):
                printEnterNameMenu("заказа");
                Order ord = getObjectByName(CompanyData.getOrders());
                printActionOrderStatusMenu();
                String status = scanner.nextLine();
                switch(status){
                    case("1"): ord.setStatus(Status.ON_STORAGE); break;
                    case("2"): ord.setStatus(Status.ON_DELIVERY); break;
                    case("3"): ord.setStatus(Status.AT_SALES_POINT); break;
                    default:
                }

                enterButtonToGetBack();
                break;

            case("4"):
                printEnterNameMenu("заказа");
                Order or = getObjectByName(CompanyData.getOrders());
                printEnterNameMenu("склада");
                Storage storage = getObjectByName(CompanyData.getStorages());
                storage.add(or.getListOfProducts());
                CompanyData.removeOrder(or.getName());

                enterButtonToGetBack();
                break;

            default: ordersMenu();
        }
    }


    private static void storagesMenu() {
        printActionStorageMenu();
        String in = scanner.nextLine();
        switch(in){
            case("1"): infoMenu(CompanyData.getStorages()); break;
            case("2"): storagesMenu(); break;
            case("3"): salingPointsMenu(); break;
            case("4"): productsMenu(); break;
            case("5"): employeesMenu(); break;
            case("6"): customersMenu(); break;
            default:
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
