package com.wellington.service;

import com.wellington.model.Pedido;
import com.wellington.model.Produto;
import com.wellington.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido salvar(Pedido pedido) {

        // calcular total automaticamente
        double total = 0;
        for (Produto p : pedido.getProdutos()) {
            total += p.getPreco();
        }

        pedido.setTotal(total);
        pedido.setDataPedido(LocalDateTime.now());
        pedido.setStatus("PENDENTE");

        return repository.save(pedido);
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }
}