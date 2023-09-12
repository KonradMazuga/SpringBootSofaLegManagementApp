package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.dao.request.OrderRequest;
import ZTI.project.SecureApplication.dao.request.OrderResponse;
import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import ZTI.project.SecureApplication.entities.Product;
import ZTI.project.SecureApplication.entities.User;
import ZTI.project.SecureApplication.repository.OrderItemRepository;
import ZTI.project.SecureApplication.repository.OrderRepository;
import ZTI.project.SecureApplication.repository.ProductRepository;
import ZTI.project.SecureApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final OrderItemRepository orderItemRepository;
    public Order saveOrder(OrderRequest orderRequest)
    {
        Order order = new Order();
        User user = userRepository.getUserById(orderRequest.getUserId());
        order.setUser(user);
        Set<OrderItem> orderItems = new HashSet<>();
        for(var orderItemRequest : orderRequest.getOrderItemRequests())
        {
            OrderItem orderItem = new OrderItem();
//            Product product = productRepository.getProductById(orderItemRequest.getProductId());

            orderItem.setProduct(orderItemRequest.getProduct());
            orderItem.setQuantity(orderItemRequest.getQuantity());
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
            orderItems.add(orderItem);
        }
//        order.setOrderItems(orderItems);
        order.setOrderDate(new Date());

//        orderItem.setProduct();
//        order.set
        return orderRepository.save(order);
    }

    public List<OrderResponse> readOrders()
    {
        List<Order> orders =  orderRepository.findAll();
        List<OrderResponse> orderResponses= new ArrayList<>();
        for(var order: orders)
        {
            OrderResponse orderResponse = OrderResponse.builder().id(order.getId()).orderDate(order.getOrderDate()).build();
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }

    public Optional<Order> getOrderById(Long id)
    {
        return orderRepository.findById(id);
    }

    public List<OrderResponse> getOrdersByUserId(Long id)
    {
        User user = userRepository.findById(id).orElseThrow(() -> new ExpressionException(""));
        List<Order> orders = orderRepository.findByUser(user);
        List<OrderResponse> orderResponses = new ArrayList<>();
        for(var order: orders)
        {
            OrderResponse orderResponse = OrderResponse.builder().id(order.getId()).orderDate(order.getOrderDate()).build();
            orderResponses.add(orderResponse);
        }
        return orderResponses;
    }
}
