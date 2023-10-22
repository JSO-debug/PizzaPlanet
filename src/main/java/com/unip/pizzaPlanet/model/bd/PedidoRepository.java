package com.unip.pizzaPlanet.model.bd;

import org.springframework.data.repository.CrudRepository;

import com.unip.pizzaPlanet.model.Pedido;
import java.util.List;


public interface PedidoRepository extends CrudRepository<Pedido, Integer>{
    List<Pedido> findByNomeOrMatricula(String nome, int matricula);
}
