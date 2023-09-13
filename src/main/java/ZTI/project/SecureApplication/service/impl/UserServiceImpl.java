package ZTI.project.SecureApplication.service.impl;

import ZTI.project.SecureApplication.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ZTI.project.SecureApplication.repository.UserRepository;
import ZTI.project.SecureApplication.service.UserService;

import lombok.RequiredArgsConstructor;

/**
 * Implementation of UserService class. This class is a business logic layer for User actions.
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    /**
     * UserDetailsService constructor with method override
     * @return new UserDetailsService object
     */
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            /**
             * UserDetailsService constructor with method override. It checks if user's email is stored in DB
             * @param username username provided in SigninRequest
             * @return new UserDetailsService object
             */
            @Override
            public UserDetails loadUserByUsername(String username) {
                return userRepository.findByEmail(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }

    /**
     * Method for user addition. Requesting userRepository to send save request to DB.
     * @param user user
     */
    public void addUser(User user)
    {
        userRepository.save(user);
    }
}
