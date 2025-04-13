package com.LembreteMedicamento.lembretemedicamento.security;

import com.LembreteMedicamento.lembretemedicamento.model.Usuario;
import com.LembreteMedicamento.lembretemedicamento.service.UsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioService usuarioService;

    public JwtAuthFilter(JwtService jwtService, UsuarioService usuarioService){
        this.jwtService = jwtService;
        this.usuarioService = usuarioService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autHeader = request.getHeader("Authorization");

        if(autHeader == null || !autHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }

        String token = autHeader.substring(7);
        String email = jwtService.pegarEmail(token);

        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Usuario usuario = usuarioService.findForEmail(email).orElseThrow();
            if(jwtService.tokenValido(token, usuario)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);

    }
}
