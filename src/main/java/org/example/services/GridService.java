package org.example.services;

import org.example.dtos.ShapeCreateDTO;

public interface GridService {
    String getGrid();

    void deleteShapeAtCoordinates(int x, int y);

    void addShape(ShapeCreateDTO shapeDTO);

}
