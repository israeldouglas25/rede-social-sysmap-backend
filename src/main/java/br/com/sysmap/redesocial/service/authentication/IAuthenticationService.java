package br.com.sysmap.redesocial.service.authentication;

public interface IAuthenticationService {
    AuthenticateResponse authenticate(AuthenticateRequest request);
}
