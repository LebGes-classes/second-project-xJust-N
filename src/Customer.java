package src;

import java.util.HashMap;
import java.util.Map;

import static src.handlers.InputHandler.printAllInfo;

public class Customer extends Profile implements Printable {
    private final Map<String, Product> listOfProducts;
    private int numberOfOrders;

    Customer(String name, int age, boolean sex) {
        super(name, age, sex);
        listOfProducts = new HashMap<>();
        numberOfOrders = 0;
    }

    public void add(Product product, int count){
        String name = product.getName();
        if(listOfProducts.containsKey(name)){
            product.addCount(count);
        }
        else{
            listOfProducts.put(name, product.copyAndSetCount(count));
        }
        numberOfOrders++;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(
                        "Всего заказов: " + numberOfOrders + "\n" +
                        "Купленные товары: "
        );
        printAllInfo(listOfProducts.values());
    }


}