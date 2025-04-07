package src;

public class Product implements Printable{
    private String name;
    private int count;
    private int price;
    private int sizeValue;

    Product(String name, int price, int sizeValue){
        CompanyData.add(this);
        setName(name);
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

    int getCount() {
        return count;
    }

    void setCount(int count) {
        this.count = count;
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
