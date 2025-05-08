package app.main.handlers;

import app.main.products.Product;

import java.util.Map;

public class ProductInputHandler extends InputHandler {
    private final Map<String, Product> availableProducts;

    ProductInputHandler(){
        availableProducts = companyData.getProducts();
    }

    @Override
    public void printMenu() {
        ui.print(
                """
                \t---Выберете действие---\t
                
                1) Показать информацию
                2) Регистрация новых товаров
                3) Удаление товара из зарегистрированных
                """
        );
    }

    @Override
    public void handle(String command){
        switch(command){
            case("1"): infoMenu(availableProducts); break;
            case("2"): registerProductMenu(); break;
            case("3"): deleteProductMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }

    private void registerProductMenu() {
        ui.print("Введите имя продукта:");
        String name = ui.readLine();
        ui.print("Введите цену за 1 шт:");
        int price = Integer.parseInt(ui.readLine());
        ui.print("Введите значение размера:");
        int size = Integer.parseInt(ui.readLine());
        companyData.add(new Product(name, price, size));
    }

    private void deleteProductMenu() {
        ui.print("Введите имя продукта:");
        String name = ui.readLine();
        companyData.remove(availableProducts.get(name));
    }

}
