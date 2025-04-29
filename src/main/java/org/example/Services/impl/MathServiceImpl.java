package org.example.Services.impl;

import org.example.Factories.ShapeFactory;
import org.example.Interfaces.Shape;
import org.example.Services.MathService;
import org.example.enums.ShapeType;
import org.springframework.stereotype.Service;

@Service
public class MathServiceImpl implements MathService {
    public double calculateArea(ShapeType type, double size) {
        Shape shape = ShapeFactory.createShape(type, size);
        return shape.calculateArea();
    }

    public double calculatePerimeter(ShapeType type, double size) {
        Shape shape = ShapeFactory.createShape(type, size);
        return shape.calculatePerimeter();
    }
}
