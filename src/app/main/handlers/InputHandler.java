package app.main.handlers;

import app.main.storage.Printable;
import app.main.products.Product;
import app.main.repository.CompanyData;
import app.main.ui.UI;

import java.util.*;

public abstract class InputHandler {
    private InputHandler nextHandler;
    protected final CompanyData companyData;
    protected final UI ui;


    InputHandler(){
        nextHandler = this;
        companyData = CompanyData.getData();
        ui = new UI();
    }

    public abstract void printMenu();
    public abstract void handle(String command);

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
                in = ui.readLine();
                ui.print(map.get(in).getInfo());
                }
        ui.readLine();
    }



    protected List<Product> getListOfProductsByName() {
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

            try {
                String[] splitInput = input.split(" ");
                if (splitInput.length != 2) {
                    throw new IllegalArgumentException("Неверный формат ввода");
                }
                String name = splitInput[0];
                int count = Integer.parseInt(splitInput[1]);
                Product availableProduct = companyData.getProducts().get(name);
                if (availableProduct == null) {
                    throw new NoSuchElementException("Такого продукта c именем " + name + " нет");
                }
                listOfProducts.add(availableProduct.copyAndSetCount(count));

            } catch (Exception e) {
                ui.printErrorMessage(e.getMessage());
            }
        }
        return listOfProducts;
    }
    
    public InputHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(InputHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
