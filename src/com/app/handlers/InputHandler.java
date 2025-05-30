package com.app.handlers;

import com.app.model.products.AvailableProduct;
import com.app.model.storage.Printable;
import com.app.model.products.Product;
import com.app.repository.CompanyData;
import com.app.ui.UI;

import java.io.IOException;
import java.util.*;

public abstract class InputHandler {    //Супертип для всех обработчиков ввода для полиморфизма
    private InputHandler nextHandler;   //Экземпляр класса, которое наследники изменяют динамически
    protected final CompanyData companyData;
    protected final UI ui;


    InputHandler(){
        nextHandler = this;
        companyData = CompanyData.getData();
        ui = new UI();
    }

    public abstract void printMenu();   //Абстрактные методы для потомков
    public abstract void handle(String command) throws IOException;

     protected void infoMenu(Map<String, ? extends Printable> map){
        ui.print(
                "\t---Выберете действие---\t\n" +
                "1) Показать обо всех\n" +
                "2) Показать об одном\n"
         );

        String in = ui.readLine();

        switch(in){
            case("1"):
                ui.printAllInfo(map.values()); break;
            case("2"):
                ui.print("Введите имя");
                ui.print(getObjectByInput(map).getInfo());
                }
        ui.waitForInput();
    }

    protected <T> T getObjectByInput(Map<String, T> map) throws NoSuchElementException{
         String name = ui.readLine();
         if(!map.containsKey(name)) throw new NoSuchElementException(name + " не найден");
         return map.get(name);
    }

    protected List<Product> getListOfProductsByInput() throws NoSuchElementException, IllegalArgumentException {
        List<Product> listOfProducts = new LinkedList<>();
        boolean flagToContinue = true;

        while (flagToContinue) {
            ui.print(
                    "Введите имя товара и его количество(0 для остановки)\n" +
                            "Формат ввода: <Имя> <Количество>\n" +
                            "Текущий список:\n");
            ui.printAllInfo(listOfProducts);

            String input = ui.readLine();
            if (input.equals("0")) {
                flagToContinue = false;
                continue;
            }

            String[] splitInput = input.split(" ");
            if (splitInput.length < 2) {
                throw new IllegalArgumentException("Неверный формат ввода");
            }
            String name = "";
            for(int i = 0; i < splitInput.length - 1; i++){
                name += splitInput[i] + " ";
            }
            int count = parseInt(splitInput[splitInput.length - 1]);
            AvailableProduct availableProduct = companyData.getProducts().get(name.trim());
            if (availableProduct == null) {
                throw new NoSuchElementException("Такого продукта c именем " + name + " нет");
            }
            listOfProducts.add(new Product(availableProduct, count));
        }
        return listOfProducts;
    }


    protected int parseInt(String number){
        if(!number.matches("^[1-9]\\d*$")) throw new IllegalArgumentException("Неверный формат ввода числа");
        return Integer.parseInt(number);
    }

    
    public InputHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(InputHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
