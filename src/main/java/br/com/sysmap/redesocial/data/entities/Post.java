package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
public class Post {
    @Id
    private UUID id;
    @DBRef
    private User userId;
    private String title;
    private String description;
    private OffsetDateTime createdAt;
    @DBRef
    private List<Comment> comments;

    public Post(String title, String description) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.createdAt = OffsetDateTime.now();
    }

    public List<Comment> addComment(Comment comment) {
        this.comments.add(comment);
        return this.comments;
    }
}
