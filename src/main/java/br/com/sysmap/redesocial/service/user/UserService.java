package br.com.sysmap.redesocial.service.user;

import br.com.sysmap.redesocial.data.entities.User;
import br.com.sysmap.redesocial.data.repository.IUserRepository;
import br.com.sysmap.redesocial.exception.EntitieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll().stream().map(UserResponse::new).toList();
    }

    @Override
    public UserResponse getByEmail(String email) {
        User byEmail = userRepository.findByEmail(email);
        if (byEmail != null) {
            return new UserResponse(byEmail);
        } else {
            throw new EntitieException("Email not found!");
        }

    }

    @Override
    public String create(UserRequest request) {
        var user = new User(request.name, request.email, request.password);
        userRepository.save(user);
        return user.getId().toString();
    }

    @Override
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new EntitieException("User not found!");
        }
        userRepository.deleteById(id);
    }

    @Override
    public void update(UUID id, UserRequest request) {
        var userDb = userRepository.findById(id).orElseThrow(() -> new EntitieException("User not found!"));
        userDb.setId(id);
        userDb.setName(request.getName());
        userDb.setEmail(request.getEmail());
        userDb.setPassword(request.getPassword());
        userRepository.save(userDb);

    }
}
