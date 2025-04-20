package src;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static src.handlers.InputHandler.*;

public class SalingPoint implements Printable {

    private String name;
    private final Map<String, Product> listOfProducts;
    private final Map<String, Employee> employees;
    private int yield;

    SalingPoint(String name) {
        setName(name);
        listOfProducts = new HashMap<>();
        employees = new HashMap<>();
        yield = 0;
    }

    public void add(Product product, int count) {
        if(listOfProducts.containsKey(product.getName())){
            listOfProducts.get(product.getName()).addCount(count);
        }
        else{
            product.setCount(count);
            listOfProducts.put(product.getName(), product);
        }
    }

    public void remove(Product pr, int count) throws IOException {
        String name = pr.getName();
        Product pointProduct = listOfProducts.get(name);

        if (pointProduct.getCount() == count) {
            listOfProducts.remove(name);
        } else if (pointProduct.getCount() >= count) {
            pointProduct.addCount(-count);
        } else {
            throw new IOException("Такого количества продукта в ячейке склада нет");
        }
    }

    public void sellToCustomer(Customer customer, Product product, int count) throws IOException {
        remove(product, count);
        customer.add(product, count);
        yield += product.getPrice() * count;
    }

    public Map<String, Product> getProducts() {
        return listOfProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void printInfo() {
        System.out.println(
                        "Название: " + name + "\n" +
                        "Доходность: " + yield + "\n" +
                        "Ответственные лица: "
        );
        printAllInfo(employees.values());

        System.out.println("Товары: ");
        printAllInfo(listOfProducts.values());

    }
}

