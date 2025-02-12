package com.example.demo.repositories;
import com.example.demo.entities.Ordem_Venda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Ordem_Venda_Repository extends CrudRepository<Ordem_Venda, Integer> {
}
