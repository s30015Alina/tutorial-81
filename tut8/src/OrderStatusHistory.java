class OrderStatusHistory {
    private int historyID;
    private int orderID;
    private String oldStatus;
    private String newStatus;
    private String changeDate;

    public OrderStatusHistory(int historyID, int orderID, String oldStatus, String newStatus, String changeDate) {
        this.historyID = historyID;
        this.orderID = orderID;
        this.oldStatus = oldStatus;
        this.newStatus = newStatus;
        this.changeDate = changeDate;
    }

    @Override
    public String toString() {
        return "OrderStatusHistory{" +
                "historyID=" + historyID +
                ", orderID=" + orderID +
                ", oldStatus='" + oldStatus + '\'' +
                ", newStatus='" + newStatus + '\'' +
                ", changeDate='" + changeDate + '\'' +
                '}';
    }
}
