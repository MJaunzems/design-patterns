package org.example.Services.impl;

import java.util.List;

import org.example.DTOs.ShapeCreateDTO;
import org.example.Entities.ShapeEntity;
import org.example.Repositories.ShapeRepository;
import org.example.Services.GridService;
import org.example.Utils.ShapeMapper;
import org.example.enums.ShapeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {

    private final int width = 10;
    private final int height = 10;

    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    public void addShape(ShapeCreateDTO shapeDTO) {
        if (!isInBounds(shapeDTO.getX(), shapeDTO.getY())) throw new IllegalArgumentException("Out of bounds");
        shapeRepository.save(ShapeMapper.toEntity(shapeDTO));
    }

    @Override
    public void deleteShapeAtCoordinates(int x, int y) {
        List<ShapeEntity> toDelete = shapeRepository.findByCoordinates(x, y);
        if (toDelete.isEmpty()) {
            throw new IllegalArgumentException("Shape not found at coordinates: " + x + ", " + y);
        }
        toDelete.forEach(s -> shapeRepository.delete(s));
    }

    @Override
    public String getGrid() {
        ShapeEntity[][] grid = new ShapeEntity[width][height];
        List<ShapeEntity> allShapes = shapeRepository.findAll();
        allShapes.forEach(s -> placeOnGrid(s, grid));

        String result = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ShapeEntity shape = grid[x][y];
                result += (shape != null ? Character.toUpperCase(shape.getColor().name().charAt(0)) + " " : ". ");
            }
            result += "\n";
        }
        return result;
    }

    private void placeOnGrid(ShapeEntity shapeEntity, ShapeEntity[][] grid) {
        int x = shapeEntity.getX();
        int y = shapeEntity.getY();
        int size = (int) shapeEntity.getSize();

        if (shapeEntity.getType() == ShapeType.SQUARE) {
            for (int dx = 0; dx < size; dx++) {
                for (int dy = 0; dy < size; dy++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    if (isInBounds(newX, newY)) {
                        grid[newX][newY] = shapeEntity;
                    }
                }
            }
        } else if (shapeEntity.getType() == ShapeType.TRIANGLE) {
            for (int dx = 0; dx < size; dx++) {
                for (int dy = 0; dy <= dx; dy++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    if (isInBounds(newX, newY)) {
                        grid[newX][newY] = shapeEntity;
                    }
                }
            }
        }
    }

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
