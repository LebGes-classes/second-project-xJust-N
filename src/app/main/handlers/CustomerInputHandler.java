package app.main.handlers;

import app.main.model.products.AvailableProduct;
import app.main.model.profile.Customer;
import app.main.model.profile.Employee;

import java.util.Map;

public class CustomerInputHandler extends InputHandler {
    private final Map<String, Customer> customers;
    CustomerInputHandler(){
        customers = companyData.getCustomers();
    }

    @Override
    public void printMenu() {
        ui.print(
                """
                \t---Выберете действие---\t
                
                1) Показать информацию
                2) Регистрация покупателя
                3) Удаление информации о покупателе
                """
        );
    }

    @Override
    public void handle(String command){
        switch(command){
            case("1"): infoMenu(customers); break;
            case("2"): registerCustomerMenu(); break;
            case("3"): deleteCustomerMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }
    private void registerCustomerMenu() {
        ui.print("Введите имя покупателя");
        String name = ui.readLine();
        ui.print("Введите возраст");
        int age = parseInt(ui.readLine());
        ui.print("Введите пол(м/ж)");
        String in = ui.readLine();
        companyData.add(new Customer(name, age, in.equals("м")));
    }

    private void deleteCustomerMenu() {
        ui.print("Введите имя покупателя:");
        companyData.remove(getObjectByInput(customers));
    }
}
