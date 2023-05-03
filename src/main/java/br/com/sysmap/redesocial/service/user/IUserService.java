package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    String create(UserRequest request);

    List<UserResponse> getAll();

    UserResponse getByEmail(String email);

    void delete(UUID id);

    void update(UUID id, UserRequest request);
    User getById(UUID id);
}
