package br.com.neki.nekicard.dto;

import java.time.LocalDate;

import br.com.neki.nekicard.model.RedesSociais;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizarPerfilDto(

    @NotNull(message = "Id é obrigatório")
    Long id,

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(neki-it\\.com\\.br|neki\\.com\\.br)$", message = "Formato do email é inválido")
    String email,

    String nomeCompleto,

    String nomeSocial,

    LocalDate dataNasc,

    String foto,

    String telefone,

    RedesSociais redesSociais
) {
    
}
