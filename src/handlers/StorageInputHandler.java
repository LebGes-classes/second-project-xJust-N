package src.handlers;

import src.Printable;
import src.Product;
import src.Storage;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import src.UI.*;

class StorageInputHandler implements InputHandler{
    private final Scanner scanner;
    private final Map<String, Storage> storages;
    
    StorageInputHandler(){
        scanner = new Scanner(System.in);
        storages = src.CompanyData.getStorages();
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): infoMenu(storages); break;
            case("2"): moveMenu(); break;
            case("3"): newStorageMenu(); break;
            case("4"): closeStorageMenu(); break;
            case("5"): addNewEmployeeMenu(); break;
            case("6"): customersMenu(); break;
        }
    }
    private void moveMenu(){
        clearConsole();
        System.out.println("Введите имя склада отправителя");
        Storage st1 = storages.get(scanner.nextLine());
        System.out.println("Введите имя склада получателя");
        Storage st2 = storages.get(scanner.nextLine());
        List<Product> listOfProducts= getListOfProductsByName();
        try{
            st1.move(st2, listOfProducts);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void newStorageMenu(){
        clearConsole();
        System.out.println("Введите имя склада");
        String name = scanner.nextLine();
        CompanyData.add(new Storage(name));
    }
    private void closeStorageMenu(){
        clearConsole();
        System.out.println("Введите имя склада");
        String name = scanner.nextLine();
        try {
            CompanyData.removeStorage(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void infoMenu(Map<String, ? extends Printable> map){
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
}
