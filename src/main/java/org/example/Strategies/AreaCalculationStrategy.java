package org.example.Strategies;

import org.example.Interfaces.CalculationStrategy;
import org.example.Interfaces.Shape;

public class AreaCalculationStrategy implements CalculationStrategy {
    @Override
    public double calculate(Shape shape) {
        return shape.calculateArea();
    }
}

