package org.example.Shapes;

import org.example.Interfaces.Shape;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square with side: " + side);
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
