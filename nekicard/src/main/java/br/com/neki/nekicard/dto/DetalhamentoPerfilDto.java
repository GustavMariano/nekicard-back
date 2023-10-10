package br.com.neki.nekicard.dto;

import java.time.LocalDate;

import br.com.neki.nekicard.model.Perfil;
import br.com.neki.nekicard.model.RedesSociais;

public record DetalhamentoPerfilDto(  Long id,

        String email,

        String nomeCompleto,

        String nomeSocial,

        LocalDate dataNasc,

        String foto,

        String telefone,

        RedesSociais redesSociais) {

        public DetalhamentoPerfilDto(Perfil perfil) {
            this(perfil.getId(), perfil.getEmail(), perfil.getNomeCompleto(), perfil.getNomeSocial(), perfil.getDataNasc(), perfil.getFoto(), perfil.getTelefone(), perfil.getRedesSociais());
        }

}
