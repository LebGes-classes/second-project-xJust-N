package repository;

import products.Product;
import profile.*;
import storage.*;

import java.util.HashMap;
import java.util.Map;

public class CompanyData {
    private static CompanyData instance = null;
    private final Map<String, Storage> storages;
    private final Map<String, SalingPoint> salingPoints;
    private final Map<String, Product> availableProducts;
    private final Map<String, Employee> employees;
    private final Map<String, Customer> customers;

    private CompanyData() {
        instance = this;
        storages = new HashMap<>();
        salingPoints = new HashMap<>();
        availableProducts = new HashMap<>();
        employees = new HashMap<>();
        customers = new HashMap<>();
    }

    public static CompanyData getData() {
        if (instance == null) {
            instance = new CompanyData();
        }
        return instance;
    }

    public void load() {

    }

    public void save() {

    }


    public void add(Storage storage) {
        storages.put(storage.getName(), storage);
    }

    public void add(SalingPoint sp) {
        salingPoints.put(sp.getName(), sp);
    }

    public void add(Product p) {availableProducts.put(p.getName(), p);}

    public void add(Employee e) {
        employees.put(e.getName(), e);
    }

    public Map<String, Storage> getStorages() {
        return storages;
    }

    public Map<String, SalingPoint> getSalingPoints() {
        return salingPoints;
    }

    public Map<String, Product> getProducts() {
        return availableProducts;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }


    public void removeStorage(String name) {
        storages.remove(name);
    }

    public void removeSalingPoint(String name) {
        salingPoints.remove(name);
    }

    public void removeEmployee(String name) {
        employees.remove(name);
    }

    public void removeProduct(String name) {
        availableProducts.remove(name);
    }
    public void removeCustomer(String name) {
        customers.remove(name);
    }
}
