package main;

public class Order {
    private Long id;
    private String status;

    public Order(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
}
