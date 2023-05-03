package br.com.sysmap.redesocial.service.post;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    String create(PostRequest request);
    List<PostResponse> getAllByUser(UUID userId);
    void delete(UUID id);
}
