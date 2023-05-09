package br.com.sysmap.redesocial.api.controller;

import br.com.sysmap.redesocial.exception.DomainException;
import br.com.sysmap.redesocial.service.authentication.AuthenticateRequest;
import br.com.sysmap.redesocial.service.authentication.AuthenticateResponse;
import br.com.sysmap.redesocial.service.authentication.IAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping
    ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequest request){
        try {
            return ResponseEntity.ok().body(authenticationService.authenticate(request));
        }catch (DomainException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
