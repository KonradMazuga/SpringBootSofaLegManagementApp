package ZTI.project.SecureApplication.dao.request;

import ZTI.project.SecureApplication.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for passing OrderItem related data from client to server
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
    private Product product;
    private Long quantity;
}
