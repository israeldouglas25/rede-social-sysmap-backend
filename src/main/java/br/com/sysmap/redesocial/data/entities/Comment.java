package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Comment {
    @DBRef
    private User userId;
    @DBRef
    private Post postId;
    private String description;
    private OffsetDateTime createdAt;

    public Comment(User userId, Post postId, String description) {
        this.userId = userId;
        this.postId = postId;
        this.description = description;
        this.createdAt = OffsetDateTime.now();
    }

}
