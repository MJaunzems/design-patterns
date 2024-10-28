package org.example.Factories;

import org.example.Shapes.Circle;
import org.example.Interfaces.Shape;
import org.example.Shapes.Square;

public class ShapeFactory {
    public static Shape createShape(String type, double size) {
        return switch (type.toLowerCase()) {
            case "circle" -> new Circle(size);
            case "square" -> new Square(size);
            default -> throw new IllegalArgumentException("Unknown shape type: " + type);
        };
    }
}
