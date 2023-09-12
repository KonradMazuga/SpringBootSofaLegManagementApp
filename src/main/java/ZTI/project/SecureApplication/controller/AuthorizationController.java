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

@RestController
@RequestMapping("/api/v1/resource")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void addDefaultUsers()
    {
        User admin = new User();
        admin.setFirstName("Johny");
        admin.setLastName("Bravo");
        admin.setEmail("jbravo@gmail.com");
        admin.setPassword(passwordEncoder.encode("pass"));
        admin.setRole(Role.ADMIN);
        userService.addUser(admin);

        User user = new User();
        user.setFirstName("John");
        user.setLastName("Cena");
        user.setEmail("jcena@gmail.com");
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

    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> sayHelloAdmin()
    {
        return ResponseEntity.ok("Hi admin");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<String> sayHelloUser1()
    {
        return ResponseEntity.ok("Hi user");
    }

}
