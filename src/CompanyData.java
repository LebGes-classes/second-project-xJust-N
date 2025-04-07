package src;

import java.util.HashMap;

class CompanyData {
    private static HashMap<String, Order> orders;
    private static HashMap<String, Storage> storages;
    private static HashMap<String, SalingPoint> salingPoints;
    private static HashMap<String, Product> products;
    private static HashMap<String, Employee> employees;
    private static HashMap<String, Customer> customers;



    static void add(Order order){
        orders.put(order.getName(), order);
    }
    static void add(Storage storage){
        storages.put(storage.getName(), storage);
    }
    static void add(SalingPoint sp){
        salingPoints.put(sp.getName(), sp);
    }
    static void add(Product p){
        products.put(p.getName(), p);
    }
    static void add(Employee e){
        employees.put(e.getName(), e);
    }
    static void add(Customer c){
        customers.put(c.getName(), c);
    }

    public static HashMap<String, Order> getOrders() {
        return orders;
    }
    public static HashMap<String, Storage> getStorages() {
        return storages;
    }

    public static HashMap<String,SalingPoint> getSalingPoints() {
        return salingPoints;
    }

    public static HashMap<String, Product> getProducts() {
        return products;
    }

    public static HashMap<String,Employee> getEmployees() {
        return employees;
    }

    public static HashMap<String,Customer> getCustomers() {
        return customers;
    }

    public static void removeOrder(String name) {
        orders.remove(name);
    }
    public static void removeStorage(String name) {
        storages.remove(name);
    }

    public static void removeSalingPoint(String name) {
        salingPoints.remove(name);
    }

    public static void removeEmployee(String name) {
        employees.remove(name);
    }

    public static void removeProduct(String name) {
        products.remove(name);
    }

    public static void removeCustomer(String name) {
        customers.remove(name);
    }


}
