package src;

import java.util.LinkedList;
import java.util.List;

public class Customer extends Profile {
    private List<Order> orders;
    private int numberOfOrders;

    Customer(String name, int age, boolean sex){
        super(name, age, sex);
        orders = new LinkedList<Order>();
        numberOfOrders = 0;
    }

    public List<Order> getOrders() {
        return orders;
    }


    public int getNumberOfOrders() {
        return numberOfOrders;
    }

    public void incNumberOfOrders() {
        numberOfOrders++;
    }



}
