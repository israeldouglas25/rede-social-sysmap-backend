package br.com.sysmap.redesocial.service.post;

import br.com.sysmap.redesocial.data.entities.Comment;
import br.com.sysmap.redesocial.data.entities.Like;
import br.com.sysmap.redesocial.data.entities.Post;
import br.com.sysmap.redesocial.data.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
public class PostResponse {
    private UUID id;
    private UUID userId;
    private String description;
    private LocalDateTime createdAt;
    private List<Comment> comments;
    private List<Like> likes;

    public PostResponse(Post post){
        this.id = post.getId();
        this.userId = post.getUserId();
        this.description = post.getDescription();
        this.createdAt = post.getCreatedAt();
        this.comments = post.getComments();
        this.likes = post.getLikes();
    }
}
