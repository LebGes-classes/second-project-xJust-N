package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Storage implements Printable{
    private final List<StorageCell> storageCells;
    private final HashMap<String, Employee> employees;
    private int size;
    private final int capacity;
    private String name;
    private static HashMap<String, SalingPoint> salingPoints;

    Storage(String name, int capacity){
       CompanyData.add(this);
        storageCells = new ArrayList<>(capacity);
        employees = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    Storage(String name){
        this(name, 4);
    }

    public static Storage openNewStorage(String name) throws IOException {
        if(!CompanyData.getStorages().containsKey(name)) {
            return new Storage(name);
        }
        else{
           throw new IOException("Склад с таким именем уже существует");
        }
    }


    public static void closeStorage(String name) throws IOException{
        CompanyData.removeStorage(name);
    }
    private StorageCell findValidCell(int neededSize){
        return null;
    }

    public void add(Product product, int count){
        StorageCell cell = findValidCell(product.getSizeValue() * count);
        cell.add(product, count);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public HashMap<String, Employee> getEmployees() {
        return employees;
    }

    public List<StorageCell> getStorageCells() {
        return storageCells;
    }


    @Override
    public void printInfo(){
        System.out.println(
                "Название: " + name + "\n" +
                        "Заполненность: " + size + "/" + capacity + "\n" +
                        "Ответственные лица: "
        );
        UI.printAllInfo(employees.values());

        System.out.println("Товары: ");
        for(StorageCell cell: storageCells){
            UI.printAllInfo(cell.getProducts());
        }

    }


}
