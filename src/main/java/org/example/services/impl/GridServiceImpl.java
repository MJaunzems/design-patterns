package org.example.services.impl;

import java.util.List;

import org.example.dtos.ShapeCreateDTO;
import org.example.entities.ShapeEntity;
import org.example.repositories.ShapeRepository;
import org.example.services.GridService;
import org.example.utils.ShapeMapper;
import org.springframework.stereotype.Service;

@Service
public class GridServiceImpl implements GridService {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private final ShapeRepository shapeRepository;

    public GridServiceImpl(ShapeRepository shapeRepository) {
        this.shapeRepository = shapeRepository;
    }

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
        toDelete.forEach(shapeRepository::delete);
    }

    @Override
    public String getGrid() {
        ShapeEntity[][] grid = new ShapeEntity[WIDTH][HEIGHT];
        List<ShapeEntity> allShapes = shapeRepository.findAll();
        allShapes.forEach(s -> placeOnGrid(s, grid));

        StringBuilder result = new StringBuilder();
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                ShapeEntity shape = grid[x][y];
                result.append(shape != null ? Character.toUpperCase(shape.getColor().name().charAt(0)) + " " : ". ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void placeOnGrid(ShapeEntity shapeEntity, ShapeEntity[][] grid) {
        int x = shapeEntity.getX();
        int y = shapeEntity.getY();
        int size = shapeEntity.getSize();

        switch (shapeEntity.getType()) {
            case SQUARE -> placeSquare(shapeEntity, grid, x, y, size);
            case TRIANGLE -> placeTriangle(shapeEntity, grid, x, y, size);
            default -> throw new IllegalArgumentException("Unexpected shape type: " + shapeEntity.getType());
        }
    }

    private void placeSquare(ShapeEntity shapeEntity, ShapeEntity[][] grid, int x, int y, int size) {
        for (int dx = 0; dx < size; dx++) {
            for (int dy = 0; dy < size; dy++) {
                int newX = x + dx;
                int newY = y + dy;
                if (isInBounds(newX, newY)) {
                    grid[newX][newY] = shapeEntity;
                }
            }
        }
    }

    private void placeTriangle(ShapeEntity shapeEntity, ShapeEntity[][] grid, int x, int y, int size) {
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

    private boolean isInBounds(int x, int y) {
        return x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT;
    }
}
