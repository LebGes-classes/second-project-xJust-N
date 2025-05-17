package app.main.handlers;

import app.main.model.products.Product;
import app.main.model.profile.Customer;
import app.main.model.profile.Employee;
import app.main.model.storage.*;

import java.io.IOException;
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
    public void handle(String command) throws IOException {
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
        SalingPoint sp = getObjectByInput(salingPoints);
        ui.print("Введите имя покупателя");
        Customer customer = getObjectByInput(customers);
        ui.print("Введите название продукта и количество");
        List<Product> listOfProducts = getListOfProductsByInput();
        sp.sellToCustomer(customer, listOfProducts);


    }
    private void returnProductsToStorageMenu(){
        ui.print("Введите название пункта продаж");
        SalingPoint sp = getObjectByInput(salingPoints);
        ui.print("Введите название склада");
        Storage storage = getObjectByInput(storages);
        ui.print("Введите название продукта и количество");
        List<Product> listOfProducts = getListOfProductsByInput();
        sp.returnToStorage(storage, listOfProducts);
    }
    private void newSalingPointMenu() throws IOException {
        ui.print("Введите имя пункта");
        String name = ui.readLine();
        if(salingPoints.containsKey(name))
            throw new IOException(name + " уже существует");
        companyData.add(new SalingPoint(name));
    }

    private void closeSalingPointMenu(){
        ui.print("Введите имя пункта");
        companyData.remove(getObjectByInput(salingPoints));
    }

    private void addEmployeeMenu(){
        ui.print("Введите имя пункта");
        SalingPoint sp = getObjectByInput(salingPoints);
        ui.print("Введите имя работника");
        Employee e = getObjectByInput(employees);
        ui.print("Введите должность");
        e.setPositionOnWork(ui.readLine());

        sp.add(e);
    }

    private void removeEmployeeMenu(){
        ui.print("Введите имя пункта");
        SalingPoint sp = getObjectByInput(salingPoints);
        ui.print("Введите имя работника");
        sp.remove(getObjectByInput(employees));
    }


}
