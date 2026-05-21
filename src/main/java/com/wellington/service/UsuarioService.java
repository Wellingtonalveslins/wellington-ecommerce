package com.wellington.service;

import com.wellington.model.Usuario;
import com.wellington.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario) {
        usuario.setPerfil("CLIENTE");
        return repository.save(usuario);
    }

    public Usuario buscarPorEmail(String email) {
        return repository.findByEmail(email).orElse(null);
    }
    public List<Usuario> listar() {
    return repository.findAll();
}
public void deletar(Long id) {
    repository.deleteById(id);
}
}