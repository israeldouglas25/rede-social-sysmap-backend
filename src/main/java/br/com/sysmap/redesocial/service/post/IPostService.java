package br.com.sysmap.redesocial.service.post;

import br.com.sysmap.redesocial.data.entities.Comment;
import br.com.sysmap.redesocial.data.entities.Like;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    String create(PostRequest request);

    List<PostResponse> getAll();

    List<PostResponse> getAllByUser(UUID userId);
    void addComent(Comment comentRequest);
    void addLike(Like likeRequest);

    void delete(UUID id);
}
