package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static src.CompanyData.*

class Storage {
    private List<StorageCell> storageCells;
    private Map<String, Employee> employees;
    private int size;
    private final int capacity;
    private String name;


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
        if(!storages.containsKey(name)) {
            return new Storage(name);
        }
        else{
           throw new IOException("Склад с таким именем уже существует");
        }
    }


    public static void closeStorage(String name) throws IOException{
        if(storages.containsKey(name)) {
            storages.remove(name);
        }
        else{
            throw new IOException("Такого склада нет");
        }
    }
    public void findValidCell(int neededSize){

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

    public Map<String, Employee> getEmployees() {
        return employees;
    }

    public List<StorageCell> getStorageCells() {
        return storageCells;
    }


}
