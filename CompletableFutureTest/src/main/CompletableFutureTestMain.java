package main;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTestMain {
	
	
	static class OrderService {
        public Order getOrder(Long orderId) {
        	System.out.println("Order processed in method ");
        	Util.simulateDelay(5000); // Simulate DB call
        	System.out.println("Order processed in method completed");
            return new Order(orderId, "Pending");
        }
    }

    static class PaymentService {
        public Payment processPayment(Order order) {
        	System.out.println("Payment processed in method ");
        	Util.simulateDelay(3000); // Simulate payment gateway call
            return new Payment(order.getId(), "Completed");
        }
    }

    static class NotificationService {
        public void sendNotification(Payment payment) {
            Util.simulateDelay(500); // Simulate notification delay
            System.out.println("Notification sent for payment: " + payment.getId());
        }
    }
    
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("works");
		
		
		
		// Example 3: Combining Multiple Futures
		CompletableFuture<String> result = combineServicesAsync(20l);
		System.out.println("result "+ result.get());
		
	}
	 // Example 1: Basic Async Operation
    public static CompletableFuture<Order> getOrderAsync(Long orderId) {
        return CompletableFuture.supplyAsync(() -> {
            OrderService orderService = new OrderService();
            return orderService.getOrder(orderId);
        });
    }

    // Example 2: Chaining Operations
    public static CompletableFuture<Payment> processOrderAsync(Long orderId) {
        return getOrderAsync(orderId)
                .thenApply(order -> {
                    PaymentService paymentService = new PaymentService();
                    return paymentService.processPayment(order);
                });
    }

    // Example 3: Combining Multiple Futures
    public static CompletableFuture<String> combineServicesAsync(Long orderId) {
        CompletableFuture<Order> orderFuture = getOrderAsync(orderId);
        CompletableFuture<Payment> paymentFuture = processOrderAsync(orderId);

        return orderFuture.thenCombine(paymentFuture, (order, payment) ->
                String.format("Order: %s, Payment: %s", order.getStatus(), payment.getStatus()));
    }
}
