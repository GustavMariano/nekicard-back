package br.com.neki.nekicard.dto;

import br.com.neki.nekicard.model.Perfil;


public record ListagemPerfilDto(

        Long id,

        String email,

        String nomeCompleto,

        String nomeSocial,

        String foto) {

        public ListagemPerfilDto(Perfil perfil) {
            this(perfil.getId(), perfil.getEmail(), perfil.getNomeCompleto(), perfil.getNomeSocial(), perfil.getFoto());
        }

}
