package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import ZTI.project.SecureApplication.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest controller for orderItem requests. Client entry point for orderItem actions
 */
@RestController
@RequestMapping("/api/v1/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    /**
     * Get orderItem by orderId from the DB via calling service layer function
     * @param id id of order for which we want to retrieve all orderItems
     * @return list of orderItems for specific orderId
     */
    @GetMapping("/{id}")
    public List<OrderItem> findByOrder(@PathVariable Long id)
    {
        return orderItemService.findAllByOrderId(id);
    }
}
