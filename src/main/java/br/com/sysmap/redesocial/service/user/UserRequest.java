package br.com.sysmap.redesocial.service.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserRequest {
    public UUID id;
    @NotBlank(message = "Digite o nome")
    public String name;
    @NotBlank(message = "Digite o e-mail")
    @Email(message = "Digite um e-mail valido!")
    public String email;
    @NotBlank(message = "Digite uma senha")
    @Size(min = 6, max = 20, message = "Mínimo de 6 e máximo de 20 caracter!")
    public String password;

}
