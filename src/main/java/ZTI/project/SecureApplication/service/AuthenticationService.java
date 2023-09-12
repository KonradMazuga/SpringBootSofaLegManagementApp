package ZTI.project.SecureApplication.service;

import ZTI.project.SecureApplication.dao.request.SignUpRequest;
import ZTI.project.SecureApplication.dao.request.SigninRequest;
import ZTI.project.SecureApplication.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SigninRequest request);
}
