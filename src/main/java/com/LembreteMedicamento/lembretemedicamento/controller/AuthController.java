package com.LembreteMedicamento.lembretemedicamento.controller;

import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getNome());
        System.out.println(usuario.getSenha());
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
