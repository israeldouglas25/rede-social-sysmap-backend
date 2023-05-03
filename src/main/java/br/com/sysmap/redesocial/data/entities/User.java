package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
    private LocalDateTime createdAt = LocalDateTime.now();

    public User(String name, String email, String password) {
        this.setId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.setPhoto();
    }

    protected void setId() {
        this.id = id.randomUUID();
    }

    public void setPhoto() {
        this.photo = "https://static.vecteezy.com/ti/vetor-gratis/t2/550731-de-icone-de-usuario-gratis-vetor.jpg";
    }

    public UUID getId() {
        return id;
    }
}
