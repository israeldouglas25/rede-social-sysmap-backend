package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Post {
    @Id
    private UUID id;
    private UUID userId;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
    private List<Comment> comments;
    private List<Like> likes;

    public Post(UUID userId, String description) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.description = description;
    }

    public List<Comment> addComment(Comment comment) {
        this.comments.add(comment);
        return this.comments;
    }

    public List<Like> addLike(Like like) {
        this.likes.add(like);
        return this.likes;
    }
}
