package org.example.Observers;

import org.example.Interfaces.Observer;
import org.example.Interfaces.Shape;

public class ShapeObserver implements Observer {
    @Override
    public void update(Shape shape) {
        System.out.println("Shape updated: " + shape);
    }
}
