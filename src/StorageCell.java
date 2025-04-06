package src;

import java.util.HashMap;

class StorageCell {
    private HashMap<String,Product> products;
    private int size;
    private final int capacity;
    StorageCell(int capacity){
        size = 0;
        this.capacity = capacity;
    }
    StorageCell(){
        this(1000);
    }
    public void add(Product product, int count){
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
    public void remove(Product products){

    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
