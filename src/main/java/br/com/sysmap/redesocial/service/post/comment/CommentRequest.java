package br.com.sysmap.redesocial.service.post.comment;

import br.com.sysmap.redesocial.data.embedded.Like;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {
    public UUID userId;
    public UUID postId;
    public String description;
    public List<Like> likes;
}
