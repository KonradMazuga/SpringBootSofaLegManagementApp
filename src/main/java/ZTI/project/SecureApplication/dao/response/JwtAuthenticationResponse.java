package ZTI.project.SecureApplication.dao.response;

import ZTI.project.SecureApplication.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for passing authentication related data from server to client
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {
    private String token;
    private Role role;
    private Long userId;
}
