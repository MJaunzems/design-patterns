package org.example.services;

import org.example.dtos.ShapeRequestDTO;

import java.util.List;

public interface ShapeService {
    List<ShapeRequestDTO> getAllShapes();

    void clearShapes();

    void deleteShapeById(Long id);
}
