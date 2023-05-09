package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    String create(UserRequest request);

    List<UserResponse> getAll();
    List<UserFriendsResponse> getAllFriends();

    UserResponse getByEmail(String email);

    User getById(UUID id);
    User getUser(String email);

    void followUser(UUID userId, UserFollowingRequest followId);

    void delete(UUID id);

    void update(UUID id, UserRequest request);

}
