package com.app.handlers;

import com.app.model.products.AvailableProduct;

import java.io.IOException;
import java.util.Map;

public class ProductInputHandler extends InputHandler {
    private final Map<String, AvailableProduct> availableProducts;

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
    public void handle(String command) throws IOException {
        switch(command){
            case("1"): infoMenu(availableProducts); break;
            case("2"): registerProductMenu(); break;
            case("3"): deleteProductMenu(); break;
            default: ui.printErrorMessage("Неверная команда");
        }
    }

    private void registerProductMenu() throws IOException {
        ui.print("Введите имя продукта:");
        String name = ui.readLine();
        if(availableProducts.containsKey(name))
            throw new IOException(name + " уже существует");

        ui.print("Введите цену за 1 шт:");
        int price = parseInt(ui.readLine());
        ui.print("Введите значение размера:");
        int size = parseInt(ui.readLine());
        companyData.add(new AvailableProduct(name, price, size));
    }

    private void deleteProductMenu() {
        ui.print("Введите имя продукта:");
        companyData.remove(getObjectByInput(availableProducts));
    }

}
