package app.main.model.products;

import app.main.model.storage.Printable;

public class Product extends AvailableProduct implements Printable {
    private int count;

    public Product(String name, int price, int sizeValue){
        this(
                name,
                price,
                sizeValue,
                0
        );
    }
    public Product(AvailableProduct pr, int count){
        super(pr.getName(), pr.getPrice(), pr.getSizeValue());
        this.count = count;
    }
    Product(String name, int price, int sizeValue, int count){
        super(name, price, sizeValue);
        setCount(count);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public void addCount(int count){this.count += count;}

    public Product copyAndSetCount(int count){
        return new Product(getName(), getPrice(), getSizeValue(), count);
    }

    @Override
    public String getInfo(){
        return super.getInfo() + "\n" +
                "|Количество товара: " + count + "\t";
    }

}
