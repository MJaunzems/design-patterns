package org.example.Decorators;

import org.example.Interfaces.Shape;

public class ShapeDecorator implements Shape {
    private final Shape decoratedShape;
    private final String color;

    public ShapeDecorator(Shape decoratedShape, String color) {
        this.decoratedShape = decoratedShape;
        this.color = color;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        System.out.println("Color: " + color);
    }

    @Override
    public double calculateArea() {
        return decoratedShape.calculateArea();
    }

    @Override
    public double calculatePerimeter() {
        return decoratedShape.calculatePerimeter();
    }
}
