abstract class Order {
    protected int orderID;
    protected int customerID;
    protected String orderDate;
    protected String status;
    protected String shippedDate;

    public Order(int orderID, int customerID, String orderDate, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.orderDate = orderDate;
        this.status = status;
        this.shippedDate = null; // initially not shipped
    }

    public abstract void updateStatus(String newStatus);
}



