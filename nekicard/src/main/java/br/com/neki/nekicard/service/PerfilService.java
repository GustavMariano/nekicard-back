package br.com.neki.nekicard.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.neki.nekicard.dto.AtualizarPerfilDto;
import br.com.neki.nekicard.dto.CadastroPerfilDto;
import br.com.neki.nekicard.dto.ListagemPerfilDto;
import br.com.neki.nekicard.model.Perfil;
import br.com.neki.nekicard.repository.PerfilRepository;

@Service
public class PerfilService {
    
    @Autowired
    private PerfilRepository perfilRepository;

    public Perfil cadastrarPerfil(CadastroPerfilDto dados) {
        return perfilRepository.save(new Perfil(dados));
    }

    public Page<ListagemPerfilDto> listarPerfis(Pageable paginacao) {
        return perfilRepository.findAll(paginacao).map(ListagemPerfilDto::new);
    }

    public Optional<Perfil> detalharPerfil(Long id) {
        return perfilRepository.findById(id);
    }

    public Perfil atualizaPerfil(AtualizarPerfilDto dados) {
        var perfil = perfilRepository.getReferenceById(dados.id());
        perfil.atualizarInformacoes(dados);
        return perfilRepository.save(perfil);
    }

    public void excluirPerfil(Long id) {
        perfilRepository.deleteById(id);
    }
}
