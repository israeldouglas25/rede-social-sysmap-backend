package br.com.sysmap.redesocial.service.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserRequest {
    public UUID id;
    public String name;
    public String email;
    public String password;

}
