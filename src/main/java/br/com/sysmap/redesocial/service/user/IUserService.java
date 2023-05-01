package br.com.sysmap.redesocial.service.user;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    String create(CreateUserRequest request);

    List<GetAllUsersRequest> getAll();

    GetUserByRequest getById(UUID id);

    void delete(UUID id);

    void update(UUID id, UpdateUserRequest request);
}
