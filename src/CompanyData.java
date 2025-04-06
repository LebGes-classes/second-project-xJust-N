package src;

import java.util.HashMap;

class CompanyData {
    private static HashMap<String, Storage> storages;
    private static HashMap<String, SalingPoint> salingPoints;
    private static HashMap<String, Product> products;
    private static HashMap<String, Employee> employees;
    private static HashMap<String, Customer> customers;

    static void add(Storage storage){
        storages.put(storage.getName(), storage);
    }
    static void add(SalingPoint sp){
        salingPoints.put(sp.getName(), sp);
    }
    static void add(Product p){
        employees.put(p.getName(), p);
    }
    static void add(Employee e){
        employees.put(e.getName(), e);
    }
    static void add(Customer c){
        customers.put(c.getName(), c);
    }
}
