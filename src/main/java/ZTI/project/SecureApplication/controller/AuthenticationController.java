package ZTI.project.SecureApplication.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ZTI.project.SecureApplication.dao.request.SignUpRequest;
import ZTI.project.SecureApplication.dao.request.SigninRequest;
import ZTI.project.SecureApplication.dao.response.JwtAuthenticationResponse;
import ZTI.project.SecureApplication.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

/**
 * Rest controller for authentication feature
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    /**
     * Sign up request from a client.
     * @param request RequestBody of client call. SignUpRequest type
     * @return token, userRole and userId
     */
    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    /**
     * Sign in request from a client. Contains a RequestBody of SigninRequest type
     * @param request RequestBody of client call. SignInRequest type
     * @return token, userRole and userId
     */
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
