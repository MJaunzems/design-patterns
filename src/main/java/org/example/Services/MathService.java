package org.example.Services;

import org.example.enums.ShapeType;

public interface MathService {
    public double calculateArea(ShapeType type, double size);

    public double calculatePerimeter(ShapeType type, double size);
}
