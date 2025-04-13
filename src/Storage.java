package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Storage implements Printable{
    private final List<StorageCell> storageCells;
    private final HashMap<String, Employee> employees;
    private int size;
    private final int capacity;
    private String name;
    private static Map<String, SalingPoint> salingPoints;

    Storage(String name, int capacity){
        storageCells = new ArrayList<>(capacity);
        employees = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    Storage(String name){
        this(name, 4);
    }

    private StorageCell findValidCell(int neededSize){
        for(StorageCell cell: storageCells){
            if(neededSize <= cell.getSize()){
                return cell;
            }
        }
        throw new RuntimeException("Не хватает места на складе");
    }

    public void add(Product product){
        int count = product.getCount();
        int size = product.getSizeValue() * count;

        StorageCell cell = findValidCell(size);
        cell.add(product, count);
        this.size += size;

    }

    public void add(List<Product> products){
        for(Product product : products){
            add(product);
        }
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
