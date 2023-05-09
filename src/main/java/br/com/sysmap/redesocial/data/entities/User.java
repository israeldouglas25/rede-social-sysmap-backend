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
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String photo;
    private List<UUID> following = new ArrayList<>();
    private List<UUID> followers = new ArrayList<>();
    private LocalDateTime createdAt;

    public User(String name, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.setPhoto();
        this.createdAt = LocalDateTime.now();
    }

    public void setPhoto() {
        this.photo = "https://static.vecteezy.com/ti/vetor-gratis/t2/550731-de-icone-de-usuario-gratis-vetor.jpg";
    }

    public void followUser(UUID userId) {
        if (following.contains(userId)) {
            following.remove(userId);
        } else {
            this.following.add(userId);
        }
    }
}
