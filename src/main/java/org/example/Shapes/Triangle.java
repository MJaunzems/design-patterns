package org.example.Shapes;

import org.example.Interfaces.Shape;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Triangle implements Shape {
    private final double side;

    @Override
    public double calculateArea() {
        return 0.5 * Math.pow(side, 2);
    }

    @Override
    public double calculatePerimeter() {
        return Math.sqrt(Math.pow(side, 2) + Math.pow(side, 2));
    }

}
