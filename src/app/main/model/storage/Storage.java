package app.main.model.storage;

import app.main.model.products.Product;
import app.main.model.profile.Employee;

 
import java.util.*;

public class Storage implements Printable, Workable {
    private final static int CELLS_COUNT = 10;
    private final static int CELL_CAPACITY = 10000;

    private final List<StorageCell> storageCells;
    private final Map<String, Employee> employees;
    private int size;
    private final int capacity;
    private String name;

    public Storage(String name) {
        this.name = name;
        storageCells = new LinkedList<>();
        for(int i = 0; i < CELLS_COUNT; i++){
            storageCells.add(new StorageCell(CELL_CAPACITY));
        }
        employees = new HashMap<>();
        size = 0;
        capacity = CELLS_COUNT * CELL_CAPACITY;
    }

    private StorageCell findValidCell(int neededSize) {
        for (StorageCell cell : storageCells) {
            if (neededSize <= cell.getCapacity()) {
                return cell;
            }
        }
        throw new IllegalStateException("Не хватает места на складе");
    }

    public void add(Product product, int count) {
        int size = product.getSizeValue() * count;

        StorageCell cell = findValidCell(size);
        cell.add(product, count);
        this.size += size;
    }

    public void add(List<Product> products) throws IllegalArgumentException {
        for (Product product : products) {
            add(product, product.getCount());
        }
    }

    @Override
    public void add(Employee employee) {
        employees.put(employee.getName(), employee);
        employee.setWork(this);
    }


    public void remove(Product product, int count) {
        StorageCell cell = findCellContainsProduct(product);
        cell.remove(product, count);
    }

    @Override
    public void remove(Employee employee){
        employees.remove(employee.getName());
        employee.setPositionOnWork(null);
        employee.removeWork();
    }

    public void move(Storage storage, List<Product> listOfProducts) {
        for (Product product : listOfProducts) {
            remove(product, product.getCount());
            storage.add(product, product.getCount());
        }

    }
    public void move(SalingPoint salingPoint, List<Product> listOfProducts) {
        for (Product product : listOfProducts) {
            remove(product, product.getCount());
            salingPoint.add(product, product.getCount());
        }

    }

    public StorageCell findCellContainsProduct(Product product) {
        int count = product.getCount();
        String name = product.getName();
        for (StorageCell cell : storageCells) {
            if (cell.getProducts().containsKey(name) && cell.getProducts().get(name).getCount() >= count) {
                return cell;
            }
        }
        throw new IllegalStateException("Склад не содержит продукт в нужном количестве");
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        String info =
                "Название: " + name + "\n" +
                "Заполненность: " + size + "/" + capacity + "\n" +
                "Ответственные лица: " + "\n";

        for(Employee e : employees.values()){
            info += e.getInfo();
        }

        info += "Товары: " + "\n";
        for(StorageCell cell : storageCells){
            for(Product p : cell.getProducts().values()){
                info += p.getInfo();
            }
        }
        return info;

    }


}
