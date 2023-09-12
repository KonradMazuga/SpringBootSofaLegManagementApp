package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import ZTI.project.SecureApplication.repository.OrderItemRepository;
import ZTI.project.SecureApplication.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemService {

    final private OrderItemRepository orderItemRepository;
    final private OrderRepository orderRepository;


    public List<OrderItem> findAllByOrderId(Long id)
    {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ExpressionException(""));
        return orderItemRepository.findAllByOrder(order);
    }

}
