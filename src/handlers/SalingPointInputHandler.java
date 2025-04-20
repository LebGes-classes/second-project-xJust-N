package src.handlers;

import src.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;


class SalingPointInputHandler extends InputHandler{
    private final Map<String, SalingPoint> salingPoints;
    private final Map<Customer> customers;
    private final Map<String, Employee> employees;

    SalingPointInputHandler(){
        salingPoints = companyData.getSalingPoints();
        customers = companyData.getCustomers();
        employees = companyData.getEmployees();
    }

    @Override
    public void printMenu() {
        clearConsole();
        System.out.println(
                """
                \t---Выберете действие---\t

                1) Показать информацию
                2) Продажа товара покупателю
                3) Возврат товаров на склад
                4) Открытие нового пункта продаж
                5) Закрытие пункта продаж
                6) Нанять работника в пункт
                7) Убрать работника с пункта
                """
        );
    }

    @Override
    public void handle(String command) {
        switch(command){
            case("1"): infoMenu(salingPoints); break;
            case("2"): sellToCustomerMenu(); break;
            case("3"): returnProductsToStorage(); break;
            case("4"): newSalingPointMenu(); break;
            case("5"): closeSalingPointMenu(); break;
            case("6"): addEmployeeMenu(); break;
            case("7"): removeEmployeeMenu(); break;
            default: printErrorMessage("Неверная команда");
        }
    }


    private void sellToCustomerMenu(){
        clearConsole();
        System.out.println("Введите имя покупателя");

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
