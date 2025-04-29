package org.example.factories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.Factories.ShapeFactory;
import org.example.Interfaces.Shape;
import org.example.Shapes.Square;
import org.example.Shapes.Triangle;
import org.example.enums.ShapeType;
import org.junit.jupiter.api.Test;

public class ShapeFactoryTest {

    @Test
    void testCreateSquareShape() {
        Shape shape = ShapeFactory.createShape(ShapeType.SQUARE, 5);

        assertNotNull(shape);
        assertTrue(shape instanceof Square);

        Square square = (Square) shape;
        assertEquals(5, square.getSide());
    }

    @Test
    void testCreateTriangleShape() {
        Shape shape = ShapeFactory.createShape(ShapeType.TRIANGLE, 5);
        assertNotNull(shape);
        assertTrue(shape instanceof Triangle);

        Triangle triangle = (Triangle) shape;
        assertEquals(5, triangle.getSide());
    }

    @Test
    void testCreateUnsupportedShape() {
        assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.createShape(ShapeType.HEXAGON, 5);
        });
    }
}
