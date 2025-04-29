package org.example.services.impl;

import org.example.factories.ShapeFactory;
import org.example.interfaces.Shape;
import org.example.services.MathService;
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
