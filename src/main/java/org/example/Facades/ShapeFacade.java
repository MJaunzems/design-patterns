package org.example.Facades;

import org.example.Decorators.ShapeDecorator;
import org.example.Factories.ShapeFactory;
import org.example.Interfaces.CalculationStrategy;
import org.example.Interfaces.Shape;
import org.example.Iterators.ShapeCollectionIterator;
import org.example.Observers.ObservableShapeCollection;
import org.example.Observers.ShapeObserver;
import org.example.Strategies.AreaCalculationStrategy;
import org.example.Strategies.PerimeterCalculationStrategy;

public class ShapeFacade {
    private final ObservableShapeCollection shapeCollection;

    public ShapeFacade() {
        this.shapeCollection = new ObservableShapeCollection();
        shapeCollection.addObserver(new ShapeObserver());
    }

    public void addCircle(double radius) {
        Shape circle = ShapeFactory.createShape("circle", radius);
        shapeCollection.addShape(circle);
    }

    public void addSquare(double side) {
        Shape square = ShapeFactory.createShape("square", side);
        shapeCollection.addShape(square);
    }

    public void addColoredCircle(double radius, String color) {
        Shape coloredCircle = new ShapeDecorator(ShapeFactory.createShape("circle", radius), color);
        shapeCollection.addShape(coloredCircle);
    }

    public void displayShapes() {
        ShapeCollectionIterator iterator = new ShapeCollectionIterator(shapeCollection);
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
            System.out.println();
            shape.draw();

            CalculationStrategy areaStrategy = new AreaCalculationStrategy();
            CalculationStrategy perimeterStrategy = new PerimeterCalculationStrategy();

            System.out.println("Area: " + areaStrategy.calculate(shape));
            System.out.println("Perimeter: " + perimeterStrategy.calculate(shape));

        }
    }
}
