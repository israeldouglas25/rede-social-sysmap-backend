package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Comment {
    private UUID userId;
    private UUID postId;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Comment(UUID userId, UUID postId, String description) {
        this.userId = userId;
        this.postId = postId;
        this.description = description;
    }

}
