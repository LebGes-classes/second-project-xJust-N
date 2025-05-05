package storage;

import products.Product;
import profile.Customer;
import profile.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalingPoint implements Printable, Workable {

    private String name;
    private final Map<String, Product> listOfProducts;
    private final Map<String, Employee> employees;
    private int yield;

    public SalingPoint(String name) {
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
    @Override
    public void add(Employee employee) {
        employees.put(employee.getName(), employee);
        employee.setWork(this);
    }

    private void remove(Product pr, int count){
        String name = pr.getName();
        Product pointProduct = listOfProducts.get(name);

        if (pointProduct.getCount() == count) {
            listOfProducts.remove(name);
        } else if (pointProduct.getCount() >= count) {
            pointProduct.addCount(-count);
        } else {
            throw new IllegalStateException("Такого количества продукта в ячейке склада нет");
        }
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee.getName());
        employee.setPositionOnWork(null);
        employee.removeWork();
    }

    public void returnToStorage(Storage storage, List<Product> listOfProducts){
        for(Product pr : listOfProducts) {
            remove(pr, pr.getCount());
            storage.add(pr, pr.getCount());
        }
    }

    public void sellToCustomer(Customer customer, List<Product> listOfProducts){
        for(Product pr : listOfProducts){
            remove(pr, pr.getCount());
            customer.add(pr, pr.getCount());
            yield += pr.getPrice() * pr.getCount();
        }
    }

    public Map<String, Product> getProducts() {
        return listOfProducts;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String getInfo() {
        String info =
                "Название: " + name + "\n" +
                "Доходность: " + yield + "\n" +
                "Ответственные лица: "+ "\n";
        for(Employee e : employees.values()){
            info += e.getInfo();
        }

        info += "Товары: " + "\n";
        for(Product p : listOfProducts.values()){
            info += p.getInfo();
        }
        return info;
    }

}

