package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.dao.request.OrderRequest;
import ZTI.project.SecureApplication.dao.request.OrderResponse;
import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Rest controller for order requests. Client entry point for order actions
 */
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    OrderController(final OrderService orderService)
    {
        this.orderService = orderService;
    }

    /**
     * Saving order to the DB via calling service layer function
     * @param orderRequest RequestBody provided by a client. OrderRequest type
     * @return order data that has been stored to the DB
     */
    @PostMapping()
    private Order saveOrder(@RequestBody OrderRequest orderRequest)
    {
        return orderService.saveOrder(orderRequest);
    }

    /**
     * Read orderId and orderDate from DB via calling service layer
     * @return list of objects of OrderResponse type
     */
    @GetMapping("/all")
    private List<OrderResponse> readOrders()
    {
        return orderService.readOrders();
    }

    /**
     * Get order data by orderId from DB via calling service layer
     * @param id id of order to be retrieved from DB
     * @return order object that has been retrieved
     */
    @GetMapping("/{id}")
    private Order getOrderById(@PathVariable Long id)
    {
        return orderService.getOrderById(id).orElseThrow(() -> new NullPointerException("No such order in database"));
    }

    /**
     * Get orderIds and orderDates for all orders from DB via calling service layer
     * @param id id of a user for who we try to collect its orderIds and orderDates
     * @return list of objects of OrderResponse type
     */
    @GetMapping("/user/{id}")
    private List<OrderResponse> getOrdersByUserId(@PathVariable Long id)
    {
        return orderService.getOrdersByUserId(id);
    }

}
