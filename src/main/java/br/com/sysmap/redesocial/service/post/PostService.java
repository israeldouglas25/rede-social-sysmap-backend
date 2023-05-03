package br.com.sysmap.redesocial.service.post;

import br.com.sysmap.redesocial.data.entities.Post;
import br.com.sysmap.redesocial.data.repository.IPostRepository;
import br.com.sysmap.redesocial.exception.EntitieException;
import br.com.sysmap.redesocial.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostService implements IPostService {
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserService userService;

    @Override
    public String create(PostRequest request) {
        if (userService.getById(request.getUserId()) != null) {
            var post = new Post(request.getUserId(), request.getDescription());
            postRepository.save(post);
            return post.getId().toString();
        } else {
            throw new EntitieException("User not found!");
        }
    }

    @Override
    public List<PostResponse> getAllByUser(UUID userId) {
        return postRepository.findAll()
                .stream()
                .filter(post -> userId.equals(post.getUserId()))
                .map(PostResponse::new)
                .toList();
    }

    @Override
    public void delete(UUID id){
        if (!postRepository.existsById(id)){
            throw new EntitieException("Post not found!");
        }
        postRepository.deleteById(id);
    }
}
