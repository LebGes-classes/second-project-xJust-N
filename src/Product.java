package src;

public class Product{
    private String name;
    private int count;
    private int price;
    private int sizeValue;

    Product(String name, int price, int sizeValue){
        setName(name);
        setPrice(price);
        setSizeValue(sizeValue);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSizeValue() {
        return sizeValue;
    }

    public void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
