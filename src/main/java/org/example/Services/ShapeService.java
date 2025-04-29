package org.example.Services;

import org.example.DTOs.ShapeRequestDTO;

import java.util.List;

public interface ShapeService {
    public List<ShapeRequestDTO> getAllShapes();

    public void clearShapes();

    public void deleteShapeById(Long id);
}
