package com.cotacao.projetoSantander.repository;

import com.cotacao.projetoSantander.model.Stock;
import com.cotacao.projetoSantander.model.dto.StockDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
/*
* Classe repository responsavel por toda parte de consulta do banco de dados.
* */

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    /*
     * Metodo para buscar no banco de dados.
     * findByNomeAndData é igual ao Where nome = " " and data = "xx/xx/xxxx"
     */
    Optional<Stock> findByNomeAndData(String nome, LocalDate data);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.nome = :nome AND stock.data = :data AND stock.id <> :id")
    Optional<Stock> findByStockUpdate(String nome, LocalDate data, Long id);

    @Query("SELECT stock " +
            "FROM Stock stock " +
            "WHERE stock.data = :data")
    Optional <List<Stock>> findByDataHoje(LocalDate data);


}


