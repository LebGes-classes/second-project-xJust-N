package handlers;

import products.Product;
import profile.Customer;
import profile.Employee;
import storage.*;

import java.util.List;
import java.util.Map;


class SalingPointInputHandler extends InputHandler{
    private final Map<String, Storage> storages;
    private final Map<String, SalingPoint> salingPoints;
    private final Map<String, Customer> customers;
    private final Map<String, Employee> employees;

    SalingPointInputHandler(){
        storages = companyData.getStorages();
        salingPoints = companyData.getSalingPoints();
        customers = companyData.getCustomers();
        employees = companyData.getEmployees();
    }

    @Override
    public void printMenu() {
        ui.print(
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
    public void handle(String command){
        switch(command){
            case("1"): infoMenu(salingPoints); break;
            case("2"): sellToCustomerMenu(); break;
            case("3"): returnProductsToStorageMenu(); break;
            case("4"): newSalingPointMenu(); break;
            case("5"): closeSalingPointMenu(); break;
            case("6"): addEmployeeMenu(); break;
            case("7"): removeEmployeeMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }


    private void sellToCustomerMenu(){
        ui.print("Введите название пункта продаж");
        SalingPoint sp = salingPoints.get(ui.readLine());
        ui.print("Введите имя покупателя");
        Customer customer = customers.get(ui.readLine());
        ui.print("Введите название продукта и количество");
        List<Product> listOfProducts = getListOfProductsByName();
        sp.sellToCustomer(customer, listOfProducts);


    }
    private void returnProductsToStorageMenu(){
        ui.print("Введите название пункта продаж");
        SalingPoint sp = salingPoints.get(ui.readLine());
        ui.print("Введите название склада");
        Storage storage = storages.get(ui.readLine());
        ui.print("Введите название продукта и количество");
        List<Product> listOfProducts = getListOfProductsByName();
        sp.returnToStorage(storage, listOfProducts);
    }
    private void newSalingPointMenu(){
        ui.print("Введите имя пункта");
        String name = ui.readLine();
        companyData.add(new SalingPoint(name));
    }

    private void closeSalingPointMenu(){
        ui.print("Введите имя пункта");
        String name = ui.readLine();
        companyData.removeSalingPoint(name);
    }

    private void addEmployeeMenu(){
        ui.print("Введите имя пункта");
        String name = ui.readLine();
        SalingPoint sp = salingPoints.get(name);
        ui.print("Введите имя работника");
        name = ui.readLine();
        sp.add(employees.get(name));
    }

    private void removeEmployeeMenu(){
        ui.print("Введите имя пункта");
        String name = ui.readLine();
        SalingPoint sp = salingPoints.get(name);
        ui.print("Введите имя работника");
        name = ui.readLine();
        sp.remove(employees.get(name));
    }


}
