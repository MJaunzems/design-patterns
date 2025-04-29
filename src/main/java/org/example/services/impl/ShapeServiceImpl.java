package org.example.services.impl;

import org.example.dtos.ShapeRequestDTO;
import org.example.repositories.ShapeRepository;
import org.example.services.ShapeService;
import org.example.utils.ShapeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShapeServiceImpl implements ShapeService {
    
    private final ShapeRepository shapeRepository;

    public ShapeServiceImpl(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

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
