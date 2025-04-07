package com.LembreteMedicamento.lembretemedicamento.service;

import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
