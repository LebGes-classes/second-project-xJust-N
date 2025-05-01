package src.handlers;

import src.objects.Printable;
import src.objects.Product;
import src.repository.CompanyData;
import src.ui.UI;

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

        String in = ui.readLine().trim().toLowerCase();

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
    


    protected List<Product> getListOfProductsByName(){
        List<Product> listOfProducts = new LinkedList<>();
        boolean flagToContinue = true;

        while(flagToContinue) {
            ui.print(
                    "Введите имя товара и его количество\n" +
                    "Формат ввода: <Имя> <Количество>\n" +
                    "Текущий список: ");
            ui.printAllInfo(listOfProducts);
            String[] input = ui.readLine().split(" ");
            String name = input[0];
            int count = Integer.parseInt(input[1]);
            Product availableProduct = companyData.getProducts().get(name);
            listOfProducts.add(availableProduct.copyAndSetCount(count));

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
