package src;

public class Product implements Printable{
    private String name;
    private int count;
    private int price;
    private int sizeValue;

    Product(String name, int price, int sizeValue){
        this(
                name,
                0,
                price,
                sizeValue
        );
    }
    Product(String name, int count, int price, int sizeValue){
        setName(name);
        setCount(count);
        setPrice(price);
        setSizeValue(sizeValue);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price = price;
    }

    int getSizeValue() {
        return sizeValue;
    }

    void setSizeValue(int sizeValue) {
        this.sizeValue = sizeValue;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    void addCount(int count){this.count += count;}

    public Product copyAndSetCount(int count){
        return new Product(name, count, price, sizeValue);
    }

    @Override
    public void printInfo(){
        System.out.println(
                        "Название: " + name + "\n" +
                        "Цена: " + price + "\n" +
                        "Количество: " + count + "\n" +
                        "Размер: " + sizeValue

        );
    }

}
