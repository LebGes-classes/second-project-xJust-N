package src;

public enum Status {
    ON_STORAGE("На складе"),
    ON_DELIVERY("В пути"),
    AT_SALES_POINT("В магазине");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
