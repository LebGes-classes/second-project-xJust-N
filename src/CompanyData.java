package src;

import java.util.Map;

class CompanyData {
    private static Map<String, Order> orders;
    private static Map<String, Storage> storages;
    private static Map<String, SalingPoint> salingPoints;
    private static Map<String, Product> products;
    private static Map<String, Employee> employees;
    private static Map<String, Customer> customers;



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

    public static Map<String, Order> getOrders() {
        return orders;
    }
    public static Map<String, Storage> getStorages() {
        return storages;
    }

    public static Map<String,SalingPoint> getSalingPoints() {
        return salingPoints;
    }

    public static Map<String, Product> getProducts() {
        return products;
    }

    public static Map<String,Employee> getEmployees() {
        return employees;
    }

    public static Map<String,Customer> getCustomers() {
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
