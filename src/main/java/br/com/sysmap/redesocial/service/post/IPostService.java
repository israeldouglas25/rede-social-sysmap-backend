package br.com.sysmap.redesocial.service.post;

import br.com.sysmap.redesocial.data.embedded.Like;
import br.com.sysmap.redesocial.data.entities.Post;
import br.com.sysmap.redesocial.service.post.comment.CommentRequest;
import br.com.sysmap.redesocial.service.post.comment.CommentResponse;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    String create(PostRequest request);

    List<PostResponse> getAll();

    List<PostResponse> getAllByUser(UUID userId);

    Post getById(UUID postId);

    CommentResponse addComent(CommentRequest commentRequest);

    void addLike(Like likeRequest);

    void delete(UUID id);
}
