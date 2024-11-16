package main;

public class Payment {
    private Long id;
    private String status;

    public Payment(Long id, String status) {
        this.id = id;
        this.status = status;
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
}

