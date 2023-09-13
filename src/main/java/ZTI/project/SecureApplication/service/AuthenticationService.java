package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.dao.request.SignUpRequest;
import ZTI.project.SecureApplication.dao.request.SigninRequest;
import ZTI.project.SecureApplication.dao.response.JwtAuthenticationResponse;

/**
 * Authentication service interface
 */
public interface AuthenticationService {
    /**
     * Sign up virtual method
     * @param request RequestBody of client call. Type of SignupRequest
     * @return user token, id and role
     */
    JwtAuthenticationResponse signup(SignUpRequest request);

    /**
     * Sign in virtual method
     * @param request RequestBody of client call. Type of SigninRequest
     * @return user token, id and role
     */
    JwtAuthenticationResponse signin(SigninRequest request);
}
