package org.example.shapes;

import org.example.interfaces.Shape;

public record Square(double side) implements Shape {
    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
