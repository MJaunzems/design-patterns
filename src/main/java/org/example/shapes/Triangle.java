package org.example.shapes;

import org.example.interfaces.Shape;

public record Triangle(double side) implements Shape {
    @Override
    public double calculateArea() {
        return 0.5 * Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.sqrt(Math.pow(side, 2) + Math.pow(side, 2));
    }

}
