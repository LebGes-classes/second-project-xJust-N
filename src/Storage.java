package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static src.CompanyData.storages;

class Storage {
    private ArrayList<StorageCell> storageCells;
    private HashMap<String, Employee> employees;
    private int size;
    private final int capacity;
    private String name;
    Storage(String name, int capacity){
       storages.put(name, this);
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

}
