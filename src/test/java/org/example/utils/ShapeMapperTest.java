package org.example.utils;

import org.example.dtos.ShapeCreateDTO;
import org.example.dtos.ShapeRequestDTO;
import org.example.entities.ShapeEntity;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeMapperTest {

    @Test
    void testToDTO() {
        ShapeEntity entity = new ShapeEntity();
        entity.setId(1L);
        entity.setType(ShapeType.SQUARE);
        entity.setSize((short) 5);
        entity.setColor(null);
        entity.setX((short) 0);
        entity.setY((short) 0);

        ShapeRequestDTO dto = ShapeMapper.toDTO(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getType(), dto.getType());
        assertEquals(entity.getSize(), dto.getSize());
        assertEquals(entity.getColor(), dto.getColor());
        assertEquals(entity.getX(), dto.getX());
        assertEquals(entity.getY(), dto.getY());
    }

    @Test
    void testToEntity() {
        ShapeCreateDTO dto = new ShapeCreateDTO();
        ShapeEntity entity = ShapeMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getType(), entity.getType());
        assertEquals(dto.getSize(), entity.getSize());
        assertEquals(dto.getColor(), entity.getColor());
        assertEquals(dto.getX(), entity.getX());
        assertEquals(dto.getY(), entity.getY());
    }
}
