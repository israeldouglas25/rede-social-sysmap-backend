package br.com.sysmap.redesocial.service.post.comment;

import br.com.sysmap.redesocial.data.embedded.Comment;
import br.com.sysmap.redesocial.data.embedded.Like;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;
@Data
@NoArgsConstructor
public class CommentResponse {
    public UUID userId;
    public String description;
    public List<Like> likes;

    public CommentResponse(Comment comment){
        this.userId = comment.getUserId();
        this.description = comment.getDescription();
        this.likes = comment.getLikes();
    }
}
