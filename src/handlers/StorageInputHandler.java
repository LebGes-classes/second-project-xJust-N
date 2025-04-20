package src.handlers;

import src.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


class StorageInputHandler extends InputHandler{

    private final Map<String, Storage> storages;
    private final Map<String, SalingPoint> salingPoints;
    private final Map<String, Employee> employees;
    
    StorageInputHandler(){
        storages = companyData.getStorages();
        salingPoints = companyData.getSalingPoints();
        employees = companyData.getEmployees();
    }

    @Override
    public void printMenu() {
        clearConsole();
        System.out.println(
                        """
                        \t---Выберете действие---\t
                        
                        1) Показать информацию
                        2) Перемещение товаров на другой склад
                        3) Отправка товара в пункт продажи
                        4) Открытие нового склада
                        5) Закрытие склада
                        6) Закуп товара на склад
                        7) Нанять работника на склад
                        8) Убрать работника со склада
                        
                        """
        );
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): infoMenu(storages); break;
            case("2"): moveProductsOnStorageMenu(); break;
            case("3"): moveProductsOnSalingPointMenu(); break;
            case("4"): newStorageMenu(); break;
            case("5"): closeStorageMenu(); break;
            case("6"): buyProductsOnStorageMenu(); break;
            case("7"): addEmployeeOnStorageMenu(); break;
            case("8"): removeEmployeeOnStorageMenu(); break;
            default: printErrorMessage("Неверная команда"); 
        }
    }


    private void moveProductsOnStorageMenu() {
        clearConsole();
        System.out.println("Введите имя склада отправителя");
        Storage st1 = storages.get(scanner.nextLine());
        System.out.println("Введите имя склада получателя");
        Storage st2 = storages.get(scanner.nextLine());
        List<Product> listOfProducts = getListOfProductsByName();
        try {
            st1.move(st2, listOfProducts);
        } catch (IOException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void moveProductsOnSalingPointMenu() {
        clearConsole();
        System.out.println("Введите имя склада отправителя");
        Storage storage = storages.get(scanner.nextLine());
        System.out.println("Введите имя пункта выдачи");
        SalingPoint salingPoint = salingPoints.get(scanner.nextLine());
        List<Product> listOfProducts = getListOfProductsByName();
        try {
            storage.move(salingPoint, listOfProducts);
        } catch (IOException e) {
            printErrorMessage(e.getMessage());
        }
    }

    private void newStorageMenu(){
        clearConsole();
        System.out.println("Введите имя склада");
        String name = scanner.nextLine().trim().toLowerCase();
        companyData.add(new Storage(name));
    }
    
    private void closeStorageMenu(){
        clearConsole();
        System.out.println("Введите имя склада");
        String name = scanner.nextLine().trim().toLowerCase();
        try {
            companyData.removeStorage(name);
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }
    private void buyProductsOnStorageMenu(){
        System.out.println("Введите имя склада");
        String name = scanner.nextLine().trim().toLowerCase();
        try {
            Storage storage = storages.get(name);
            List<Product> listOfProducts = getListOfProductsByName();
            storage.add(listOfProducts);
        } catch (IOException e) {
            printErrorMessage(e.getMessage());
        }
    }
    private void addEmployeeOnStorageMenu(){
        System.out.println("Введите имя склада");
        String name = scanner.nextLine().trim().toLowerCase();
        Storage storage = storages.get(name);
        System.out.println("Введите имя работника");
        name = scanner.nextLine().trim().toLowerCase();
        storage.add(employees.get(name));
    }

    private void removeEmployeeOnStorageMenu(){
        System.out.println("Введите имя склада");
        String name = scanner.nextLine().trim().toLowerCase();
        Storage storage = storages.get(name);
        System.out.println("Введите имя работника");
        name = scanner.nextLine().trim().toLowerCase();
        storage.remove(employees.get(name));
    }


}
