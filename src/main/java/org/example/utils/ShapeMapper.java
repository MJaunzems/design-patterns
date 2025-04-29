package org.example.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.dtos.ShapeCreateDTO;
import org.example.dtos.ShapeRequestDTO;
import org.example.entities.ShapeEntity;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeMapper {
    public static ShapeRequestDTO toDTO(ShapeEntity entity) {
        ShapeRequestDTO dto = new ShapeRequestDTO();
        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setSize(entity.getSize());
        dto.setColor(entity.getColor());
        dto.setX(entity.getX());
        dto.setY(entity.getY());
        return dto;
    }

    public static ShapeEntity toEntity(ShapeCreateDTO dto) {
        ShapeEntity entity = new ShapeEntity();
        entity.setType(dto.getType());
        entity.setSize(dto.getSize());
        entity.setColor(dto.getColor());
        entity.setX(dto.getX());
        entity.setY(dto.getY());
        return entity;
    }
}
