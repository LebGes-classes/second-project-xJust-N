package com.app.repository;

import com.app.model.products.AvailableProduct;
import com.app.model.profile.Customer;
import com.app.model.profile.Employee;
import com.app.model.storage.SalingPoint;
import com.app.model.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class CompanyData{       //Класс - хранитель данных с маппингом объектов
    private static CompanyData instance;
    private final Map<String, Storage> storages;
    private final Map<String, SalingPoint> salingPoints;
    private final Map<String, AvailableProduct> availableProducts;
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

    public void save() {
        JsonDataHandler dataHandler = new JsonDataHandler();
        try {
            dataHandler.saveToJson(instance);
        } catch (Exception e) {
            throw new RuntimeException("Невозможно сохранить файл!: " + e.getMessage());
        }
    }

    public void load() {
        JsonDataHandler dataHandler = new JsonDataHandler();
        try {
            instance = dataHandler.loadFromJson(CompanyData.class);
        } catch (Exception e) {
            throw new RuntimeException("Невозможно загрузить файл!: " + e.getMessage());
        }
    }


    public void add(Storage storage) {
        storages.put(storage.getName(), storage);
    }

    public void add(SalingPoint sp) {
        salingPoints.put(sp.getName(), sp);
    }

    public void add(AvailableProduct p) {availableProducts.put(p.getName(), p);}

    public void add(Employee e) {
        employees.put(e.getName(), e);
    }

    public void add(Customer c) {customers.put(c.getName(), c);}
    public Map<String, Storage> getStorages() {
        return storages;
    }

    public Map<String, SalingPoint> getSalingPoints() {
        return salingPoints;
    }

    public Map<String, AvailableProduct> getProducts() {
        return availableProducts;
    }

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public Map<String, Customer> getCustomers() {
        return customers;
    }


    public void remove(Storage st) {
        storages.remove(st.getName());
    }

    public void remove(SalingPoint sp) {
        salingPoints.remove(sp.getName());
    }

    public void remove(Employee e) {
        employees.remove(e.getName());
    }

    public void remove(AvailableProduct pr) {
        availableProducts.remove(pr.getName());
    }
    public void remove(Customer c) {
        customers.remove(c.getName());
    }

}
