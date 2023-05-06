package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserFriendsResponse {
    public String name;
    public String photo;
    public List<UUID> following;

    public UserFriendsResponse(User user) {
        this.name = user.getName();
        this.photo = user.getPhoto();
        this.following = user.getFollowing();
    }
}
