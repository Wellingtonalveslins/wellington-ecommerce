package com.wellington.controller;

import com.wellington.model.Usuario;
import com.wellington.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        Usuario novo = service.cadastrar(usuario);
        return ResponseEntity.ok(novo);
    }
    @PostMapping("/login")
public ResponseEntity<String> login(@RequestBody Usuario usuario) {
    Usuario encontrado = service.buscarPorEmail(usuario.getEmail());
    if (encontrado != null && encontrado.getSenha().equals(usuario.getSenha())) {
        return ResponseEntity.ok("LOGIN_OK:" + encontrado.getNome());
    }
    return ResponseEntity.status(401).body("Email ou senha incorretos!");
}
@GetMapping
public List<Usuario> listar() {
    return service.listar();
}
@DeleteMapping("/{id}")
public void deletar(@PathVariable Long id) {
    service.deletar(id);
}
}