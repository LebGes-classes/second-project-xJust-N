package src;

import java.util.Collection;
import java.util.List;
import java.util.Map;

class StorageCell {
    private Map<String,Product> products;
    private int size;
    private final int capacity;

    StorageCell(int capacity){
        size = 0;
        this.capacity = capacity;
    }
    StorageCell(){
        this(1000);
    }

    public void add(Product product){
        int count = product.getCount();
        String name = product.getName();

        if(size + product.getSizeValue() * count <= capacity) {
            if(!products.containsKey(name)){ //не содержит такой продукт
                products.put(name, product);
            }
            else{
                product = products.get(name);// если содержит = ссылка на него
            }
            product.setCount(product.getCount() + count);
            size += product.getSizeValue() * count;
        }
        else{
            throw new RuntimeException("Не хватает места");
        }
    }

    public void remove(Product product, int count){
        if(product.getCount() <= count){
            products.remove(product.getName());
        }
        else{
            products.get(product.getName());
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public Collection<Product> getProducts(){
        return products.values();
    }

}
