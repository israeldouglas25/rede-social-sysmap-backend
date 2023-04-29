package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import br.com.sysmap.redesocial.data.repository.IUserRepository;
import br.com.sysmap.redesocial.exception.EntitieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<GetAllUsersRequest> getAll() {
        return userRepository.findAll().stream().map(GetAllUsersRequest::new).toList();
    }

    @Override
    public GetUserByRequest getById(UUID id) {
        var user = userRepository.findById(id).orElseThrow(() -> new EntitieNotFoundException("User not found!"));
        return new GetUserByRequest(user);
    }

    @Override
    public String create(CreateUserRequest request) {
        var user = new User(request.name, request.email, request.password, request.fone);
        userRepository.save(user);
        return user.getId().toString();
    }

    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new EntitieNotFoundException("User not found!");
        }
        userRepository.deleteById(id);
    }
}
