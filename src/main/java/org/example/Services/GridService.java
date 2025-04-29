package org.example.Services;

import org.example.DTOs.ShapeCreateDTO;

public interface GridService {
    public String getGrid();

    public void deleteShapeAtCoordinates(int x, int y);

    public void addShape(ShapeCreateDTO shapeDTO);

}
