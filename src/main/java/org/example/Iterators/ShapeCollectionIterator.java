package org.example.Iterators;

import org.example.Interfaces.Shape;
import org.example.Observers.ObservableShapeCollection;

import java.util.Iterator;

public class ShapeCollectionIterator implements Iterator<Shape> {
    private final Iterator<Shape> iterator;

    public ShapeCollectionIterator(ObservableShapeCollection shapeCollection) {
        this.iterator = shapeCollection.getShapes().iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Shape next() {
        return iterator.next();
    }
}
