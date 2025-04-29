package org.example.dtos;

import org.example.enums.ColorName;
import org.example.enums.ShapeType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShapeCreateDTO {
    private ShapeType type;
    private short size;
    private ColorName color;
    private short x;
    private short y;
}