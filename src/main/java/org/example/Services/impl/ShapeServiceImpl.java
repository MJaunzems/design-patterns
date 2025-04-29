package org.example.Services.impl;

import org.example.DTOs.ShapeRequestDTO;
import org.example.Repositories.ShapeRepository;
import org.example.Services.ShapeService;
import org.example.Utils.ShapeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {
    
    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    public List<ShapeRequestDTO> getAllShapes() {
        return shapeRepository.findAll().stream().map(ShapeMapper::toDTO).toList();
    }

    @Override
    public void deleteShapeById(Long id) {
        shapeRepository.deleteById(id);
    }

    @Override
    public void clearShapes() {
        shapeRepository.deleteAll();
    }
}
