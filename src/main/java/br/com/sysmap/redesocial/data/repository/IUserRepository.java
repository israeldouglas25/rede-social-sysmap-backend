package br.com.sysmap.redesocial.data.repository;

import br.com.sysmap.redesocial.data.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IUserRepository extends MongoRepository<User, UUID> {
    User findByEmail(String email);
}
