package org.example.services;

import org.example.enums.ShapeType;

public interface MathService {
    double calculateArea(ShapeType type, double size);

    double calculatePerimeter(ShapeType type, double size);
}
