package ZTI.project.SecureApplication.service.impl;

import ZTI.project.SecureApplication.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ZTI.project.SecureApplication.dao.request.SignUpRequest;
import ZTI.project.SecureApplication.dao.request.SigninRequest;
import ZTI.project.SecureApplication.dao.response.JwtAuthenticationResponse;
import ZTI.project.SecureApplication.entities.Role;
import ZTI.project.SecureApplication.entities.User;
import ZTI.project.SecureApplication.repository.UserRepository;
import ZTI.project.SecureApplication.service.AuthenticationService;
import ZTI.project.SecureApplication.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        var user = User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
                .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(Role.USER).userId(user.getId()).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).role(user.getRole()).userId(user.getId()).build();
    }
}
