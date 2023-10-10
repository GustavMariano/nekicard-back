package br.com.neki.nekicard.model;

import jakarta.persistence.Embeddable;
import br.com.neki.nekicard.dto.RedesSociaisDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RedesSociais {

    private String linkedin;

    private String github;

    private String instagram;

    private String facebook;

    public RedesSociais(RedesSociaisDto dados) {
        this.linkedin = dados.linkedin();
        this.github = dados.github();
        this.instagram = dados.instagram();
        this.facebook = dados.facebook();
    }

    public void atualizarInformacoes(RedesSociais redesSociais) {
        if (redesSociais.linkedin != null) {
            this.linkedin = redesSociais.linkedin;
        }
        if (redesSociais.github != null) {
            this.github = redesSociais.github;
        }
        if (redesSociais.instagram != null) {
            this.instagram = redesSociais.instagram;
        }
        if (redesSociais.facebook != null) {
            this.facebook = redesSociais.facebook;
        }
    }
}
