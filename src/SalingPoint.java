package src;

import java.util.HashMap;
import java.util.Map;

public class SalingPoint {

    private String name;
    private final Map<String, Product> products;

    SalingPoint(String name){
        setName(name);
        products = new HashMap<String, Product>();
    }


    public Map<String,Product> getProducts() {
        return products;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
