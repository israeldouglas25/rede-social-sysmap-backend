package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class GetAllUsersRequest {
    public UUID id;
    public String name;

    public GetAllUsersRequest(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
