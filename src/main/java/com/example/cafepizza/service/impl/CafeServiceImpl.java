package com.example.cafepizza.service.impl;

import com.example.cafepizza.model.Cafe;
import com.example.cafepizza.repository.CafeRepository;

import com.example.cafepizza.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CafeServiceImpl implements CafeService {
    private final CafeRepository cafeRepository;
    @Autowired
    public CafeServiceImpl(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    @Override
    public List<Cafe> findAll() {
        return cafeRepository.findAll();
    }
    public void deleteCafe(Long id) { cafeRepository.deleteById(id);}
    public Optional<Cafe> findById(Long id) {
        return cafeRepository.findById(id);
    }
    public void addOrUpdate(Cafe cafe) { cafeRepository.save(cafe);}
}
