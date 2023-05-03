package br.com.sysmap.redesocial.service.post;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PostRequest {
    public UUID userId;
    @NotEmpty(message = "Não pode ser nulo nem vazio!")
    public String description;
}
