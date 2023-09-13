package ZTI.project.SecureApplication.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for passing Product related data from client to server
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private String productName;
    private Long categoryId;
}
