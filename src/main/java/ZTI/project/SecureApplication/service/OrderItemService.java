package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import ZTI.project.SecureApplication.repository.OrderItemRepository;
import ZTI.project.SecureApplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderItem service that is a business layer for handling order items
 */
@Service
@RequiredArgsConstructor
public class OrderItemService {

    final private OrderItemRepository orderItemRepository;
    final private OrderRepository orderRepository;


    /**
     * Get orderItems for a specific orderId from DB via repository
     * @param id orderId
     * @return list of orderItems for a specific orderId
     */
    public List<OrderItem> findAllByOrderId(Long id)
    {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ExpressionException(""));
        return orderItemRepository.findAllByOrder(order);
    }

}
