package src;

import java.util.Map;

class CompanyData {

    private static Map<String, Storage> storages;
    private static Map<String, SalingPoint> salingPoints;
    private static Map<String, Product> avaiableProducts;
    private static Map<String, Employee> employees;



    public static void add(Storage storage){
        storages.put(storage.getName(), storage);
    }
    public static void add(SalingPoint sp){
        salingPoints.put(sp.getName(), sp);
    }
    public static void add(Product p){
        avaiableProducts.put(p.getName(), p);
    }
    public static void add(Employee e){
        employees.put(e.getName(), e);
    }

    public static Map<String, Storage> getStorages() {
        return storages;
    }
    public static Map<String,SalingPoint> getSalingPoints() {
        return salingPoints;
    }
    public static Map<String, Product> getProducts() {
        return avaiableProducts;
    }
    public static Map<String,Employee> getEmployees() {
        return employees;
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
        avaiableProducts.remove(name);
    }




}
