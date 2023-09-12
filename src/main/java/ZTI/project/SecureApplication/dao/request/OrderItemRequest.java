package ZTI.project.SecureApplication.dao.request;

import ZTI.project.SecureApplication.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
//    private Long productId;
    private Product product;
    private Long quantity;
}
