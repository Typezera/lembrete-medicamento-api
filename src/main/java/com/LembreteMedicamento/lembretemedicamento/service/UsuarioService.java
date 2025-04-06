package com.LembreteMedicamento.lembretemedicamento.service;

import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario){
        usuarioRepository.save(usuario);
    }
}
