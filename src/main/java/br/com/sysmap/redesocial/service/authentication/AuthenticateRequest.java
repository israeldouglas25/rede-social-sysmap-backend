package br.com.sysmap.redesocial.service.authentication;

import lombok.Data;

@Data
public class AuthenticateRequest {
    public String email;
    public String password;
}
