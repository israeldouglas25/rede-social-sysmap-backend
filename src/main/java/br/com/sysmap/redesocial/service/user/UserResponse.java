package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserResponse {

    public UUID id;
    public String name;
    public String email;
    public String password;
    public String photo;
    public List<UUID> following;
    public List<UUID> followers;
    public LocalDateTime createdAt;

    public UserResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.photo = user.getPhoto();
        this.following = user.getFollowing();
        this.followers = user.getFollowers();
        this.createdAt = user.getCreatedAt();
    }
}
