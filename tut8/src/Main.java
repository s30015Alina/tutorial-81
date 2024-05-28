public class Main {
    public static void main(String[] args) {
        // Create order
        ConcreteOrder order = new ConcreteOrder(1, 101, "2024-05-28 12:00:00", "Processing");

        // Create logger and add it as a listener
        OrderStatusLogger logger = new OrderStatusLogger();
        order.addOrderStatusListener(logger);

        // Update status
        order.updateStatus("Shipped");
        order.updateStatus("Delivered");

        // Print order details
        System.out.println(order);

        // Print status history
        for (OrderStatusHistory history : logger.getHistoryList()) {
            System.out.println(history);
        }
    }
}