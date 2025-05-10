package app.main.model.storage;

import app.main.model.products.Product;
import app.main.model.profile.Customer;
import app.main.model.profile.Employee;

 
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
        employee.setWorkName(name);
    }

    public void add(List<Product> listOfProducts) {
        for(Product pr : listOfProducts){
            this.listOfProducts.put(pr.getName(), pr);
        }
    }

    private void remove(Product pr, int count){
        String name = pr.getName();
        Product pointProduct = listOfProducts.get(name);

        if (pointProduct.getCount() == count) {
            listOfProducts.remove(name);
        } else {
            pointProduct.addCount(-count);
        }
    }

    private void remove(List<Product> listOfProducts) {
        for(Product pr : listOfProducts){
            remove(pr, pr.getCount());
        }
    }

    @Override
    public void remove(Employee employee) {
        employees.remove(employee.getName());
        employee.setPositionOnWork(null);
        employee.removeWork();
    }

    public void returnToStorage(Storage storage, List<Product> listOfProducts){
        if(!(storage.canAdd(listOfProducts) && canRemove(listOfProducts)))
            throw new IllegalStateException("Невозможно переместить товары");

        remove(listOfProducts);
        storage.add(listOfProducts);
    }



    public void sellToCustomer(Customer customer, List<Product> listOfProducts){
        if(!canRemove(listOfProducts))
            throw new IllegalStateException("Невозможно удалить товары, так как " + name + " не содержит их в нужном количестве");

        for(Product pr : listOfProducts){
            remove(pr, pr.getCount());
            customer.add(pr, pr.getCount());
            yield += pr.getPrice() * pr.getCount();
        }
    }

    boolean canAdd(List<Product> products){
        return true;
    }
    boolean canRemove(List<Product> products){
        for(Product pr : products){
            if(!(listOfProducts.containsKey(pr.getName()) && listOfProducts.get(pr.getName()).getCount() >= pr.getCount()))
                return false;
        }
        return true;
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

