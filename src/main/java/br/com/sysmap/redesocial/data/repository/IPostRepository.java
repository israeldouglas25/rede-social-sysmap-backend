package br.com.sysmap.redesocial.data.repository;

import br.com.sysmap.redesocial.data.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IPostRepository extends MongoRepository<Post, UUID> {
}
