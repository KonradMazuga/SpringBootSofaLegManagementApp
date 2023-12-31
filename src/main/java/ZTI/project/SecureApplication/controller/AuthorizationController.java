package ZTI.project.SecureApplication.controller;

import ZTI.project.SecureApplication.entities.Role;
import ZTI.project.SecureApplication.entities.User;
import ZTI.project.SecureApplication.service.impl.UserServiceImpl;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Rest controller for authorization feature
 */
@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    /**
     * Addition of default users with roles: USER or ADMIN
     */
    @PostConstruct
    public void addDefaultUsers()
    {
        try {
            User admin = new User();
            admin.setFirstName("Johny");
            admin.setLastName("Bravo");
            admin.setEmail("jbravo@gmail.com");
            admin.setPassword(passwordEncoder.encode("pass"));
            admin.setRole(Role.ADMIN);
            userService.addUser(admin);

            User admin2 = new User();
            admin2.setFirstName("Admin");
            admin2.setLastName("Admin");
            admin2.setEmail("admin@gmail.com");
            admin2.setPassword(passwordEncoder.encode("pass"));
            admin2.setRole(Role.ADMIN);
            userService.addUser(admin2);

            User user = new User();
            user.setFirstName("User");
            user.setLastName("User");
            user.setEmail("user@gmail.com");
            user.setPassword(passwordEncoder.encode(("pass")));
            user.setRole(Role.USER);
            userService.addUser(user);

            User user2 = new User();
            user2.setFirstName("Ja");
            user2.setLastName("Uzytkownik");
            user2.setEmail("ja@gmail.com");
            user2.setPassword(passwordEncoder.encode(("pass")));
            user2.setRole(Role.USER);
            userService.addUser(user2);

            User user3 = new User();
            user3.setFirstName("John");
            user3.setLastName("Cena");
            user3.setEmail("jcena@gmail.com");
            user3.setPassword(passwordEncoder.encode(("pass")));
            user3.setRole(Role.USER);
            userService.addUser(user3);
        }
        catch (Exception e)
        {
            System.out.println("There is already a user with such email");
        }
    }

    /**
     * Admin data request from a client. Checks if role=ADMIN
     * @return String to client.
     */
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHelloAdmin()
    {
        return ResponseEntity.ok("Hi admin");
    }

    /**
     * User data request from a client. Checks if role=USER
     * @return String to client.
     */
    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> sayHelloUser()
    {
        return ResponseEntity.ok("Hi user");
    }

}
