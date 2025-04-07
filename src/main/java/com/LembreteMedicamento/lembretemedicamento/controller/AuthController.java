package com.LembreteMedicamento.lembretemedicamento.controller;

import com.LembreteMedicamento.lembretemedicamento.dto.LoginRequest;
import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> criarConta(@RequestBody Usuario usuario){
        Usuario salvo = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> logar(@RequestBody LoginRequest login){
        Optional<Usuario> usuarioOpt = usuarioService.findForEmail(login.getEmail());

        if(usuarioOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado");
        }

        Usuario usuario = usuarioOpt.get();

        if(!usuario.getSenha().equals(login.getSenha())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta!");
        }

        return ResponseEntity.ok(usuario);
    }
}
