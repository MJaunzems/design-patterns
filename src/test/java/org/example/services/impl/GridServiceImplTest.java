package org.example.services.impl;

import org.example.dtos.ShapeCreateDTO;
import org.example.entities.ShapeEntity;
import org.example.repositories.ShapeRepository;
import org.example.enums.ColorName;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GridServiceImplTest {

    @InjectMocks
    private GridServiceImpl gridService;

    @Mock
    private ShapeRepository mockRepository;
    
    @BeforeEach
    void setUp() {
        mockRepository = mock(ShapeRepository.class);
        gridService = new GridServiceImpl(mockRepository);
    }

    @Test
    void testAddShapeValid() {
        ShapeCreateDTO shapeDTO = new ShapeCreateDTO();
        shapeDTO.setType(ShapeType.SQUARE);
        shapeDTO.setSize((short) 5);
        shapeDTO.setColor(null);
        shapeDTO.setX((short) 0);
        shapeDTO.setY((short) 0);

        gridService.addShape(shapeDTO);

        verify(mockRepository, times(1)).save(any(ShapeEntity.class));
    }

    @Test
    void testAddShapeInvalid() {
        ShapeCreateDTO shapeDTO = new ShapeCreateDTO();
        shapeDTO.setType(ShapeType.SQUARE);
        shapeDTO.setSize((short) 5);
        shapeDTO.setColor(null);
        shapeDTO.setX((short) -1);
        shapeDTO.setY((short)-1);

        assertThrows(IllegalArgumentException.class, () -> gridService.addShape(shapeDTO));
        verify(mockRepository, times(0)).save(any(ShapeEntity.class));
    }

    @Test
    void testDeleteShapeAtCoordinatesValid() {
        int x = 0;
        int y = 0;

        ShapeEntity shapeEntity = new ShapeEntity();
        shapeEntity.setId(1L);
        shapeEntity.setType(ShapeType.SQUARE);
        shapeEntity.setSize((short) 5);
        shapeEntity.setColor(null);
        shapeEntity.setX((short) x);
        shapeEntity.setY((short) y);

        when(mockRepository.findByCoordinates(x, y)).thenReturn(List.of(shapeEntity));

        gridService.deleteShapeAtCoordinates(x, y);

        verify(mockRepository, times(1)).delete(shapeEntity);
    }

    @Test
    void testDeleteShapeAtCoordinatesInvalid() {
        int x = 0;
        int y = 0;

        when(mockRepository.findByCoordinates(x, y)).thenReturn(List.of());

        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> gridService.deleteShapeAtCoordinates(x, y));
        assertEquals("Shape not found at coordinates: " + x + ", " + y, ex.getMessage());
        verify(mockRepository, times(0)).delete(any(ShapeEntity.class));
    }

    @Test
    void testGetGridSquare() {
        ShapeEntity shapeEntity = new ShapeEntity();
        shapeEntity.setId(1L);
        shapeEntity.setType(ShapeType.SQUARE);
        shapeEntity.setSize((short) 2);
        shapeEntity.setColor(ColorName.RED);
        shapeEntity.setX((short) 0);
        shapeEntity.setY((short) 0);

        when(mockRepository.findAll()).thenReturn(List.of(shapeEntity));

        String grid = gridService.getGrid();
        String[] gridLines = grid.split("\n");
        assertTrue(gridLines[0].startsWith("R R . "));
        assertTrue(gridLines[1].startsWith("R R . "));
        assertTrue(gridLines[2].startsWith(". . . "));

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void testGetGridSTriangle() {
        ShapeEntity shapeEntity = new ShapeEntity();
        shapeEntity.setId(1L);
        shapeEntity.setType(ShapeType.TRIANGLE);
        shapeEntity.setSize((short) 2);
        shapeEntity.setColor(ColorName.RED);
        shapeEntity.setX((short) 0);
        shapeEntity.setY((short) 0);

        when(mockRepository.findAll()).thenReturn(List.of(shapeEntity));

        String grid = gridService.getGrid();
        String[] gridLines = grid.split("\n");
        assertTrue(gridLines[0].startsWith("R R . "));
        assertTrue(gridLines[1].startsWith(". R . "));
        assertTrue(gridLines[2].startsWith(". . . "));

        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void testGetGridNoShapes() {
        when(mockRepository.findAll()).thenReturn(List.of());

        String grid = gridService.getGrid();
        String[] gridLines = grid.split("\n");

        for (String line : gridLines) {
            assertTrue(line.matches(". . . . . . . . . . "));
        }

        verify(mockRepository, times(1)).findAll();
    }
}
