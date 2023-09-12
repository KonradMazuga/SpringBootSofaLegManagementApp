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


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    OrderController(final OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping()
    private Order saveOrder(@RequestBody OrderRequest orderRequest)
    {
        return orderService.saveOrder(orderRequest);
    }

    @GetMapping("/all")
    private List<OrderResponse> readOrders()
    {
        return orderService.readOrders();
    }

    @GetMapping("/{id}")
    private Order getOrderById(@PathVariable Long id)
    {
        return orderService.getOrderById(id).orElseThrow(() -> new NullPointerException("No such order in database"));
    }

    @GetMapping("/user/{id}")
    private List<OrderResponse> getOrdersByUserId(@PathVariable Long id)
    {
        return orderService.getOrdersByUserId(id);
    }

}
