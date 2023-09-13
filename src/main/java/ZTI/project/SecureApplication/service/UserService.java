package ZTI.project.SecureApplication.service;

import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * User service interface for authorization handling
 */
public interface UserService {
    /**
     * Delete product from DB via repository
     * @return UserDetailsService object
     */
    UserDetailsService userDetailsService();
}
