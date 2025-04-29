package org.example.factories;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.interfaces.Shape;
import org.example.shapes.Square;
import org.example.shapes.Triangle;
import org.example.enums.ShapeType;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ShapeFactory {
    public static Shape createShape(ShapeType type, double size) {
        return switch (type) {
            case SQUARE -> new Square(size);
            case TRIANGLE -> new Triangle(size);
            default -> throw new IllegalArgumentException("Unsupported shape type: " + type);
        };
    }
}
