package com.cotacao.projetoSantander.service;

import com.cotacao.projetoSantander.exceptions.BusinessException;
import com.cotacao.projetoSantander.exceptions.NotFoundException;
import com.cotacao.projetoSantander.mapper.StockMapper;
import com.cotacao.projetoSantander.model.Stock;
import com.cotacao.projetoSantander.model.dto.StockDTO;
import com.cotacao.projetoSantander.repository.StockRepository;
import com.cotacao.projetoSantander.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByNomeAndData(dto.getNome(), dto.getData());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtil.STOCK_JA_EXISTE);
        }

        Stock stock = mapper.toEntity(dto);
        repository.save(stock);

        return mapper.toDto(stock);
    }

    @Transactional
    public StockDTO update(StockDTO dto) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(dto.getNome(), dto.getData(), dto.getId());
        if(optionalStock.isPresent()){
            throw new BusinessException(MessageUtil.STOCK_JA_EXISTE);
        }
        Stock stock = mapper.toEntity(dto);
        repository.save(stock);
        return mapper.toDto(stock);

    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        return mapper.toDto(repository.findAll());
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO dto = this.findById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findByDataHoje() {
        return repository.findByDataHoje(LocalDate.now()).map(mapper::toDto).orElseThrow(NotFoundException::new);
    }
}
