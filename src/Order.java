package src;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Order implements Printable {

    private final String name;
    private final Customer recipient;
    private final List<Product> listOfProducts;
    private int price = 0;
    private final SalingPoint deliveryPoint;
    private Status status;




    public Order(String name, Customer recipient, List<Product> listOfProducts, SalingPoint deliveryPoint) {
        CompanyData.add(this);
        this.name = name;
        this.recipient = recipient;
        this.listOfProducts = listOfProducts;
        price = getPriceOfProducts(listOfProducts);
        this.status = Status.ON_STORAGE;
        this.deliveryPoint = deliveryPoint;
    }
    public Order(Customer recipient, SalingPoint deliveryPoint) {
        this(
               generateOrderName(recipient),
                recipient,
                new LinkedList<>(),
                deliveryPoint
        );
    }
    public Order(Customer recipient, List<Product> listOfProducts, SalingPoint deliveryPoint) {
        this(
                generateOrderName(recipient),
                recipient,
                listOfProducts,
                deliveryPoint
        );
    }


    public void add(Product product, int count){
        listOfProducts.add(product);
        price += product.getPrice() * count;
    }

    private static String generateOrderName(Customer recipient){
        return recipient.getName() + "'s order № " + (recipient.getNumberOfOrders() + 1);
    }
    public String getName() {
        return name;
    }

    public Customer getRecipient() {
        return recipient;
    }

    public int getPrice() {
        return price;
    }

    public List<Product> getListOfProducts() {
        return listOfProducts;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private static int getPriceOfProducts(List<Product> listOfProducts){
        int sum = 0;
        for(Product product : listOfProducts){
            sum += product.getPrice() * product.getCount();
        }
        return sum;
    }

    @Override
    public void printInfo(){
        System.out.println(
                "Название: " + name + "\n" +
                        "Сумма оплаты: " + price + "\n" +
                        "Получатель: " + recipient.getName() + "\n" +
                        "Статус: " + status + "\n" +
                        "Пункт доставки: " + deliveryPoint.getName()
        );

        System.out.println("Товары: ");
        UI.printAllInfo(listOfProducts);
    }

}