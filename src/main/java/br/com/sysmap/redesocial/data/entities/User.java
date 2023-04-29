package br.com.sysmap.redesocial.data.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@NoArgsConstructor
@Data
public class User {
    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String fone;

    public User(String name, String email, String password, String fone) {
        this.setId();
        this.name = name;
        this.email = email;
        this.password = password;
        this.fone = fone;
    }

    protected void setId() {
        this.id = id.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
