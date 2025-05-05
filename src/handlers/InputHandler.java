package handlers;

import storage.Printable;
import products.Product;
import repository.CompanyData;
import ui.UI;

import java.util.*;

public abstract class InputHandler {
    private static InputHandler currentHandler;
    protected final CompanyData companyData;
    protected final UI ui;


    public abstract void printMenu();
    public abstract void handle(String command);


    InputHandler(){
        companyData = CompanyData.getData();
        ui = new UI();
    }

     void infoMenu(Map<String, ? extends Printable> map){
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
                    throw new IllegalArgumentException("Такого продукта нет");
                }
                listOfProducts.add(availableProduct.copyAndSetCount(count));

            } catch (Exception e) {
                ui.printErrorMessage(e.getMessage());
            }
        }
        return listOfProducts;
    }
    
    public static InputHandler getCurrentHandler() {
        return currentHandler;
    }

    public static void setCurrentHandler(InputHandler currentHandler) {
        InputHandler.currentHandler = currentHandler;
    }
}
