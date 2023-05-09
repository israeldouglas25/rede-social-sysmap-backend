package br.com.sysmap.redesocial.service.authentication;

import br.com.sysmap.redesocial.exception.EntitieException;
import br.com.sysmap.redesocial.service.security.IJwtService;
import br.com.sysmap.redesocial.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IJwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        var user = iUserService.getUser(request.email);

        if (user == null) {
            throw new EntitieException("User not found!");
        }
        if (!passwordEncoder.matches(request.password, user.getPassword())) {
            throw new EntitieException("Password invalid!");
        }

        var token = jwtService.generateToken(user.getId());

        var response = new AuthenticateResponse();
        response.setUserId(user.getId());
        response.setToken(token);

        return response;
    }
}
