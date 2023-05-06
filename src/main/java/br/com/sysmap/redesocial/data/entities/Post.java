package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Post {
    @Id
    private UUID id;
    private UUID userId;
    private String description;
    private LocalDateTime createdAt;
    private List<Comment> comments = new ArrayList<>();
    private List<Like> likes = new ArrayList<>();

    public Post(UUID userId, String description) {
        this.id = UUID.randomUUID();
        this.userId = userId;
        this.description = description;
        this.createdAt = LocalDateTime.now();
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    public void likePost(Like like) {
        if (likes.contains(like)) {
            likes.remove(like);
        } else {
            this.likes.add(like);
        }
    }
}
