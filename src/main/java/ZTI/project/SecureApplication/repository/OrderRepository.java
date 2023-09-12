package ZTI.project.SecureApplication.repository;

import ZTI.project.SecureApplication.entities.Order;
import ZTI.project.SecureApplication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
