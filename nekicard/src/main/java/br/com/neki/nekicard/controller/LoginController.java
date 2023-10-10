package br.com.neki.nekicard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.neki.nekicard.dto.LoginDto;
import br.com.neki.nekicard.dto.TokenJWTDto;
import br.com.neki.nekicard.model.Usuario;
import br.com.neki.nekicard.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    @Operation(summary = "Efetuar login", description = "Endpoint para autenticação de usuários.", responses = {
            @ApiResponse(responseCode = "200", description = "Sucesso ao efetuar login. Retorna o token de acesso."),
            @ApiResponse(responseCode = "403", description = "Credenciais inválidas. Não foi possível autenticar o usuário.")
    })
    public ResponseEntity<TokenJWTDto> efetuarLogin(@RequestBody @Valid LoginDto dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var usuario = (Usuario) authentication.getPrincipal();
        var tokenJWT = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new TokenJWTDto(usuario.getId(), tokenJWT));
    }

}
