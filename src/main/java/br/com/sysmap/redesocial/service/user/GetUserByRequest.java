package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserByRequest {
    private String name;
    private String email;
    private String password;
    private String fone;

    public GetUserByRequest(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.fone = user.getFone();
        this.password = user.getPassword();
    }
}
