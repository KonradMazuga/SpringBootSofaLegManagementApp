package ZTI.project.SecureApplication.repository;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findAllByOrder(Order order);
}
