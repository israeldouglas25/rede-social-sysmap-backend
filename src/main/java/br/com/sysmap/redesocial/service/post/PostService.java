package br.com.sysmap.redesocial.service.post;

import br.com.sysmap.redesocial.data.entities.Comment;
import br.com.sysmap.redesocial.data.entities.Like;
import br.com.sysmap.redesocial.data.entities.Post;
import br.com.sysmap.redesocial.data.entities.User;
import br.com.sysmap.redesocial.data.repository.IPostRepository;
import br.com.sysmap.redesocial.exception.EntitieException;
import br.com.sysmap.redesocial.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<PostResponse> getAll(){
        return postRepository.findAll()
                .stream()
                .map(PostResponse::new)
                .toList();
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
    public void addComent(Comment commentRequest){
        Post postById = postRepository.findById(commentRequest.getPostId())
                .orElseThrow(() -> new EntitieException("Post not found!"));

        User userById = userService.getById(commentRequest.getUserId());
        if (userById != null) {
            var newComment = new Comment(commentRequest.getUserId(), commentRequest.getPostId(), commentRequest.getDescription());
            postById.addComment(newComment);
            postRepository.save(postById);
        }else {
            throw new EntitieException("User not found!");
        }
    }

    @Override
    public void addLike(Like likeRequest){
        Post postById = postRepository.findById(likeRequest.getPostId())
                .orElseThrow(() -> new EntitieException("Post not found!"));

        User userById = userService.getById(likeRequest.getUserId());
        if (userById != null){
            var newlike = new Like(likeRequest.getUserId(), likeRequest.getPostId());
            postById.addLike(newlike);
            postRepository.save(postById);
        }else {
            throw new EntitieException("User not found!");
        }
    }

    @Override
    public void delete(UUID id){
        if (!postRepository.existsById(id)){
            throw new EntitieException("Post not found!");
        }
        postRepository.deleteById(id);
    }
}
