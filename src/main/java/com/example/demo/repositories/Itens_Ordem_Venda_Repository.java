package com.example.demo.repositories;
import com.example.demo.entities.Itens_Ordem_Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Itens_Ordem_Venda_Repository extends CrudRepository<Itens_Ordem_Venda, Integer> {

}
