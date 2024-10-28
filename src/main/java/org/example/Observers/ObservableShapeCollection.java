package org.example.Observers;

import org.example.Interfaces.Observer;
import org.example.Interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ObservableShapeCollection {
    private final List<Shape> shapes = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
        notifyObservers(shape);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(Shape shape) {
        for (Observer observer : observers) {
            observer.update(shape);
        }
    }

    public Iterable<Shape> getShapes() {
        return shapes;
    }
}
