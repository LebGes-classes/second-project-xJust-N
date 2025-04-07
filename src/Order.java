package src;

import java.util.HashMap;

public class Order {

    private final String name;
    private final Customer recipient;
    private int price;
    private Status status;
    private HashMap<String, Product> listOfProducts;
    private SalingPoint deliveryPoint;



    public Order(String name, Customer recipient, int price, HashMap<String, Product> listOfProducts) {
        CompanyData.add(this);
        this.name = name;
        this.recipient = recipient;
        this.price = price;
        this.listOfProducts = listOfProducts;
        this.status = Status.ON_STORAGE;
    }
    public Order(Customer recipient, int price, HashMap<String, Product> listOfProducts) {
        this(
               generateOrderName(recipient),
                recipient,
                price,
                listOfProducts
        );
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

    public HashMap<String, Product> getListOfProducts() {
        return listOfProducts;
    }


    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



}