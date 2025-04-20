package src.handlers;

import src.*;

import java.util.*;

public abstract class InputHandler {
    protected final CompanyData companyData;
    protected Scanner scanner;
    private static InputHandler currentHandler;


    public abstract void printMenu();
    public abstract void handle(String command);
    
    InputHandler(){
        companyData = CompanyData.getData();
        scanner = new Scanner(System.in);
    }
     void infoMenu(Map<String, ? extends Printable> map){
        clearConsole();
        printAllOrOneMenu();
        String in = scanner.nextLine().trim().toLowerCase();
        switch(in){
            case("1"): printAllInfo(map.values()); break;
            case("2"):
                System.out.println("Введите имя");
                in = scanner.nextLine().trim().toLowerCase();
                try {
                    map.get(in).printInfo();
                } catch (Exception e) {
                    printErrorMessage(e.getMessage());
                }
                break;
        }
        scanner.nextLine();
    }
    
    public static void printAllInfo(Collection< ? extends Printable> c){
        for(Printable element : c){
            element.printInfo();
        }
    }

    protected List<Product> getListOfProductsByName(){
        List<Product> listOfProducts = new LinkedList<>();
        boolean flagToContinue = true;
        String name;
        int count;
        while(flagToContinue) {
            clearConsole();
            System.out.println(
                    "Введите имя товара и его количество(введите 0 для конца)\n" +
                    "Список товаров в заказе: ");

            printAllInfo(listOfProducts);
            if (scanner.hasNext()) {
                name = scanner.next();
                if(name.equals("0")){
                    flagToContinue = false;
                }
                if (scanner.hasNextInt()) {
                    count = scanner.nextInt();
                    try {
                        Product availableProduct = companyData.getProducts().get(name);
                        listOfProducts.add(availableProduct.copyAndSetCount(count));
                    }
                    catch (Exception e){
                        printErrorMessage(e.getMessage());
                    }
                }
            }
        }
        return listOfProducts;
    }
    
    public static InputHandler getCurrentHandler() {
        if(currentHandler == null){
            setCurrentHandler(new MainMenuInputHandler());
        }
        return currentHandler;
    }

    public static void setCurrentHandler(InputHandler currentHandler) {
        InputHandler.currentHandler = currentHandler;
    }
    public void printErrorMessage(String message){
        System.out.println("Ошибка! " + message);
    }

    public void clearConsole(){
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }

    public void printAllOrOneMenu(){
        clearConsole();
        System.out.println(
                """
                \t---Выберете действие---\t
                
                1) Показать обо всех
                2) Показать об одном
                
                """
        );
    }


}
