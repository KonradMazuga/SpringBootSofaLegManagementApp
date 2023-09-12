package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import ZTI.project.SecureApplication.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orderItem")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping("/{id}")
    public List<OrderItem> findByOrder(@PathVariable Long id)
    {
        return orderItemService.findAllByOrderId(id);
    }
}
