package ZTI.project.SecureApplication.service;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * JwtService interface that will be used for JWT token handling
 */
public interface JwtService {
    /**
     * Get subject from JWT token. In our case it is email
     * @param token JWT token
     * @return user's email
     */
    String extractUserName(String token);

    /**
     * Generate JWT token for a user
     * @param userDetails user data
     * @return JWT token
     */
    String generateToken(UserDetails userDetails);

    /**
     * Check if JWT token is not expired
     * @param userDetails user data
     * @return bool if JWT token is not expired
     */
    boolean isTokenValid(String token, UserDetails userDetails);
}
