package br.com.neki.nekicard.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroPerfilDto(

        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(neki-it\\.com\\.br|neki\\.com\\.br)$", message = "e-mail deve terminar com @neki-it.com.br ou @neki.com.br") 
        @NotBlank(message = "Email é obrigatório") 
        String email,

        @NotBlank(message = "Nome é obrigatório") 
        String nomeCompleto,

        String nomeSocial,

        @NotNull(message = "Data de nascimento é obrigatório") 
        LocalDate dataNasc, 

        @NotBlank(message = "Foto é obrigatório") 
        String foto,

        String telefone,

        RedesSociaisDto redesSociais) {

    public CadastroPerfilDto {
        if (redesSociais == null) {
            redesSociais = new RedesSociaisDto("", "", "", "");
        }
    }
}
