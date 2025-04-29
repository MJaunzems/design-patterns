package org.example.Services.impl;

import org.example.DTOs.ShapeRequestDTO;
import org.example.Entities.ShapeEntity;
import org.example.Repositories.ShapeRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ShapeServiceImplTest {

    @InjectMocks
    private static ShapeServiceImpl shapeService;

    @Mock
    private static ShapeRepository mockRepository;

    @BeforeAll
    static void setUp() {
        mockRepository = mock(ShapeRepository.class);
        shapeService = new ShapeServiceImpl();
    }

    @Test
    void testGetAllShapes() {
        ShapeEntity shapeEntity1 = new ShapeEntity();
        shapeEntity1.setId(1L);
        ShapeEntity shapeEntity2 = new ShapeEntity();
        shapeEntity2.setId(2L);

        when(mockRepository.findAll()).thenReturn(List.of(shapeEntity1, shapeEntity2));

        List<ShapeRequestDTO> shapes = shapeService.getAllShapes();

        assertNotNull(shapes);
        assertEquals(2, shapes.size());
        assertEquals(shapeEntity1.getId(), shapes.get(0).getId());
        assertEquals(shapeEntity2.getId(), shapes.get(1).getId());
        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void testGetAllShapesEmptyList() {
        when(mockRepository.findAll()).thenReturn(List.of());

        List<ShapeRequestDTO> shapes = shapeService.getAllShapes();

        assertEquals(0, shapes.size());
        verify(mockRepository, times(1)).findAll();
    }

    @Test
    void testDeleteShapeById() {
        Long shapeId = 1L;

        shapeService.deleteShapeById(shapeId);

        verify(mockRepository, times(1)).deleteById(shapeId);
    }

    @Test
    void testClearShapes() {
        shapeService.clearShapes();

        verify(mockRepository, times(1)).deleteAll();
    }
}
