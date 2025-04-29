package org.example.factories;

import org.example.interfaces.Shape;
import org.example.shapes.Square;
import org.example.shapes.Triangle;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeFactoryTest {

    @Test
    void testCreateSquareShape() {
        Shape shape = ShapeFactory.createShape(ShapeType.SQUARE, 5);

        assertNotNull(shape);
        assertInstanceOf(Square.class, shape);

        Square square = (Square) shape;
        assertEquals(5, square.side());
    }

    @Test
    void testCreateTriangleShape() {
        Shape shape = ShapeFactory.createShape(ShapeType.TRIANGLE, 5);
        assertNotNull(shape);
        assertInstanceOf(Triangle.class, shape);

        Triangle triangle = (Triangle) shape;
        assertEquals(5, triangle.side());
    }

    @Test
    void testCreateUnsupportedShape() {
        assertThrows(IllegalArgumentException.class, () -> ShapeFactory.createShape(ShapeType.HEXAGON, 5));
    }
}
