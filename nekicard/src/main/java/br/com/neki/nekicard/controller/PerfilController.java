package br.com.neki.nekicard.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.neki.nekicard.dto.AtualizarPerfilDto;
import br.com.neki.nekicard.dto.CadastroPerfilDto;
import br.com.neki.nekicard.dto.DetalhamentoPerfilDto;
import br.com.neki.nekicard.dto.ListagemPerfilDto;
import br.com.neki.nekicard.model.Perfil;
import br.com.neki.nekicard.service.PerfilService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilController {
    
    @Autowired
    private PerfilService perfilService;

    @Operation(summary = "Cadastrar um novo perfil", description = "Cria um novo perfil com base nos dados fornecidos.")
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhamentoPerfilDto> cadastrarPerfil(
            @RequestBody @Valid CadastroPerfilDto dados, UriComponentsBuilder uriBuilder) {
        var perfil = perfilService.cadastrarPerfil(dados);
        var uri = uriBuilder.path("/perfil/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhamentoPerfilDto(perfil));
    }

    @Operation(summary = "Listar perfis", description = "Retorna uma lista paginada de perfis.")
    @GetMapping
    public ResponseEntity<Page<ListagemPerfilDto>> listarPerfis(
            @Parameter(description = "Página de resultados") @PageableDefault(size = 200, sort = {"nomeCompleto"}) Pageable paginacao) {
        var page = perfilService.listarPerfis(paginacao);
        return ResponseEntity.ok(page);
    }

    @Operation(summary = "Detalhar um perfil por ID", description = "Retorna os detalhes de um perfil com base no ID fornecido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Perfil encontrado"),
        @ApiResponse(responseCode = "404", description = "Perfil não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> detalharPerfil(@PathVariable Long id) {
        Optional<Perfil> perfil = perfilService.detalharPerfil(id);
        return perfil.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Atualizar um perfil", description = "Atualiza um perfil existente com base nos dados fornecidos.")
    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoPerfilDto> atualizarPerfil(@RequestBody @Valid AtualizarPerfilDto dados) {
        var perfil = perfilService.atualizaPerfil(dados);
        return ResponseEntity.ok(new DetalhamentoPerfilDto(perfil));    
    }

    @Operation(summary = "Excluir um perfil por ID", description = "Exclui um perfil com base no ID fornecido.")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirPerfil(@PathVariable Long id) {
        perfilService.excluirPerfil(id);
        return ResponseEntity.noContent().build();
    }
}
