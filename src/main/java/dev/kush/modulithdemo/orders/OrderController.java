package dev.kush.modulithdemo.orders;

import dev.kush.modulithdemo.inventory.InventoryUpdateEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
class OrderController {

    private final OrderRepository orderRepository;

    private final ApplicationEventPublisher eventPublisher;

    public OrderController(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @PostMapping()
    @Transactional
    public void createOrder(@RequestParam("itemId") int itemId, @RequestParam("quantity") int quantity) {
        Order order = new Order(null, itemId,quantity, LocalDateTime.now());

        var saved = orderRepository.save(order);

        System.out.println("Order is created: " + saved);

        eventPublisher.publishEvent(new InventoryUpdateEvent(itemId, quantity));
    }
}
