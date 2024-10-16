package br.com.app.coleta.lixo.dto;
import br.com.app.coleta.lixo.models.UsuarioRole;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

public record UsuarioCadastroDTO(
        @NotBlank(message = "Atributo Nome é obrigtório")
        String nome,
        @NotBlank(message = "Atributo Nome é obrigtório")
        String email,
        @Min(value = 3, message = "A senha deve ter no minimo 3 caracters")
        @NotBlank(message = "Atributo Senha é obrigtório")
        String senha,
        UsuarioRole role
) {
}
