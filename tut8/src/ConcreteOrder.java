import java.text.SimpleDateFormat;
import java.util.*;

class ConcreteOrder extends Order {
    private List<OrderStatusListener> listeners = new ArrayList<>();

    public ConcreteOrder(int orderID, int customerID, String orderDate, String status) {
        super(orderID, customerID, orderDate, status);
    }

    public void addOrderStatusListener(OrderStatusListener listener) {
        listeners.add(listener);
    }

    @Override
    public void updateStatus(String newStatus) {
        if (!this.status.equals(newStatus)) {
            String oldStatus = this.status;
            this.status = newStatus;
            String changeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            if (newStatus.equalsIgnoreCase("Shipped")) {
                this.shippedDate = changeDate;
            }

            for (OrderStatusListener listener : listeners) {
                listener.onStatusChanged(orderID, oldStatus, newStatus, changeDate);
            }
        }
    }

    @Override
    public String toString() {
        return "ConcreteOrder{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", orderDate='" + orderDate + '\'' +
                ", status='" + status + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                '}';
    }
}

class OrderStatusLogger implements OrderStatusListener {
    private List<OrderStatusHistory> historyList = new ArrayList<>();
    private int historyIDCounter = 1;

    @Override
    public void onStatusChanged(int orderID, String oldStatus, String newStatus, String changeDate) {
        OrderStatusHistory history = new OrderStatusHistory(historyIDCounter++, orderID, oldStatus, newStatus, changeDate);
        historyList.add(history);
        System.out.println("Status changed: " + history);
    }

    public List<OrderStatusHistory> getHistoryList() {
        return historyList;
    }
}

