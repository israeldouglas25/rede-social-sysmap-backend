package br.com.sysmap.redesocial.data.embedded;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class Comment {
    private UUID userId;
    private UUID postId;
    @NotEmpty(message = "Não pode ser vazio!")
    private String description;
    private List<Like> likes;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Comment(UUID userId, UUID postId, String description) {
        this.userId = userId;
        this.postId = postId;
        this.description = description;
        this.likes = new ArrayList<>();
    }

    public void likeComment(Like like) {
        if (likes.contains(like)) {
            likes.remove(like);
        } else {
            this.likes.add(like);
        }
    }

}
