package br.com.sysmap.redesocial.service.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UpdateUserRequest {
    public UUID id;
    public String name;
    public String email;
    public String password;

}
