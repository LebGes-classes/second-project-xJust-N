package src;

import java.util.HashMap;
import java.util.Map;

public class SalingPoint {

    private String name;
    private Map<String, Order> orders;

    SalingPoint(String name){
        setName(name);
        orders = new HashMap<String, Order>();
    }


    public Map<String,Order> getOrders() {
        return orders;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
