package org.example.DTOs;

import org.example.enums.ColorName;
import org.example.enums.ShapeType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShapeRequestDTO {
    private Long id;
    private ShapeType type;
    private short size;
    private ColorName color;
    private short x;
    private short y;
}
