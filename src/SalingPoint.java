package src;

import java.util.HashMap;

public class SalingPoint {

    private String name;
    private HashMap<String, Order> orders;

    SalingPoint(String name){
        CompanyData.add(this);
        setName(name);
        orders = new HashMap<String, Order>();
    }


    public HashMap<String,Order> getOrders() {
        return orders;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
