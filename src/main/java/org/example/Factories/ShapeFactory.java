package org.example.Factories;

import org.example.Interfaces.Shape;
import org.example.Shapes.Square;
import org.example.Shapes.Triangle;
import org.example.enums.ShapeType;

public class ShapeFactory {
    public static Shape createShape(ShapeType type, double size) {
        return switch (type) {
            case SQUARE -> new Square(size);
            case TRIANGLE -> new Triangle(size);
            default -> throw new IllegalArgumentException("Unsupported shape type: " + type);
        };
    }
}
