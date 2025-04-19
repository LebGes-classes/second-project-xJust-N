package src;

import java.io.IOException;
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

    public void add(Product product, int count) throws IOException{
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
            throw new IOException("Не хватает места");
        }
    }

    public void remove(Product pr, int count) throws IOException{
        String name = pr.getName();
        Product cellProduct = products.get(name);
        if(cellProduct.getCount() == count){
            products.remove(name);
        }
        else if(cellProduct.getCount() >= count){
            cellProduct.addCount(- count);
        }
        else{
            throw new IOException("Такого количества продукта на складе нет");
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public Map<String, Product> getProducts(){
        return products;
    }

}
