package br.com.neki.nekicard.model;

import java.time.LocalDate;

import br.com.neki.nekicard.dto.AtualizarPerfilDto;
import br.com.neki.nekicard.dto.CadastroPerfilDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "perfil")
@Entity(name = "Perfil")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Perfil {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nomeCompleto;

    private String nomeSocial;

    private LocalDate dataNasc;

    private String foto;

    private String telefone;

    @Embedded
    private RedesSociais redesSociais;


    public Perfil(CadastroPerfilDto dados) {
        this.email = dados.email();
        this.nomeCompleto = dados.nomeCompleto();
        this.nomeSocial = dados.nomeSocial();
        this.dataNasc = dados.dataNasc();
        this.foto = dados.foto();
        this.telefone = dados.telefone();
        this.redesSociais = new RedesSociais(dados.redesSociais());
    }

    public void atualizarInformacoes(AtualizarPerfilDto dados) {
        if (dados.email() != null && dados.email() != "") {
            this.email = dados.email();
        }
        if (dados.nomeCompleto() != null && dados.nomeCompleto() != "") {
            this.nomeCompleto = dados.nomeCompleto();
        }
        if (dados.nomeSocial() != null) {
            this.nomeSocial = dados.nomeSocial();
        }
        if (dados.dataNasc() != null) {
            this.dataNasc = dados.dataNasc();
        }
        if (dados.foto() != null && dados.foto() != "") {
            this.foto = dados.foto();
        }
        if (dados.telefone() != null && dados.telefone() != "") {
            this.telefone = dados.telefone();
        }
        if (dados.redesSociais() != null) {
            this.redesSociais.atualizarInformacoes(dados.redesSociais());
        }
    }
}
