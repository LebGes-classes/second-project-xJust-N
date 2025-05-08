package app.main.storage;

import app.main.products.Product;

 
import java.util.HashMap;
import java.util.Map;

class StorageCell{
    private final Map<String, Product> products;
    private int size;
    private final int capacity;

    StorageCell(int capacity) {
        products = new HashMap<>();
        size = 0;
        this.capacity = capacity;
    }

    StorageCell() {
        this(1000);
    }


    public void add(Product product, int count) {
        String name = product.getName();

        if (size + product.getSizeValue() * count <= capacity) {
            if (products.containsKey(name)) {         // если содержит такой продукт = ссылка на него
                product = products.get(name);
            } else {                                   // иначе - помещаем в ячейку
                products.put(name, product);
            }
            product.addCount(count);
            size += product.getSizeValue() * count;
        } else {
            throw new IllegalStateException("Не хватает места");
        }
    }

    public void remove(Product pr, int count) {
        String name = pr.getName();
        Product cellProduct = products.get(name);

        if (cellProduct.getCount() == count) {
            products.remove(name);
            size -= pr.getSizeValue() * count;
        } else if (cellProduct.getCount() >= count) {
            cellProduct.addCount(-count);
            size -= pr.getSizeValue() * count;
        } else {
            throw new IllegalArgumentException("Такого количества продукта в ячейке склада нет");
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

}
