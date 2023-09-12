package ZTI.project.SecureApplication.dao.request;

import ZTI.project.SecureApplication.entities.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long userId;
    private Set<OrderItemRequest> orderItemRequests;
}
