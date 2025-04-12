package com.LembreteMedicamento.lembretemedicamento.service;

import com.LembreteMedicamento.lembretemedicamento.dto.LoginRequest;
import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import static org.springframework.web.servlet.function.ServerResponse.status;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario salvar(Usuario usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Optional<Usuario> findForEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    public Usuario verifyUser(LoginRequest login){
       Usuario usuario = usuarioRepository.findByEmail(login.getEmail())
               .orElseThrow(() -> new RuntimeException("Usuario não inexistente"));

        if(!usuario.getSenha().equals(login.getSenha())){
            throw new RuntimeException("senha incorreta!");
        }

        return usuario;
    }
}
