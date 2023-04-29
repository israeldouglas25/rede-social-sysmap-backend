package br.com.sysmap.redesocial.service.user;

import lombok.Data;

@Data
public class CreateUserRequest {
    public String name;
    public String email;
    public String password;
    public String fone;
}
