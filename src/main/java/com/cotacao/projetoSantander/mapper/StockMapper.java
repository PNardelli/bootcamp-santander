package com.cotacao.projetoSantander.mapper;

import com.cotacao.projetoSantander.model.Stock;
import com.cotacao.projetoSantander.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO dto){

        Stock stock = new Stock();

        stock.setId(dto.getId());
        stock.setNome(dto.getNome());
        stock.setPreco(dto.getPreco());
        stock.setVariacao(dto.getVariacao());
        stock.setData(dto.getData());
        return stock;
    }

    public StockDTO toDto(Stock stock) {
        StockDTO dto = new StockDTO();

        dto.setId(stock.getId());
        dto.setNome(stock.getNome());
        dto.setPreco(stock.getPreco());
        dto.setVariacao(stock.getVariacao());
        dto.setData(stock.getData());
        return dto;
    }

    public List<StockDTO> toDto(List<Stock> listStock){
        return listStock.stream().map(this::toDto).collect(Collectors.toList());
    }
}
