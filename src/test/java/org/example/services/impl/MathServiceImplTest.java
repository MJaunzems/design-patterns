package org.example.services.impl;

import org.example.enums.ShapeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceImplTest {
    private final MathServiceImpl mathService = new MathServiceImpl();

    @Test
    void testCalculateAreaForSquare() {
        double area = mathService.calculateArea(ShapeType.SQUARE, 4);
        assertEquals(16, area);
    }

    @Test
    void testCalculatePerimeterForSquare() {
        double perimeter = mathService.calculatePerimeter(ShapeType.SQUARE, 4);
        assertEquals(16, perimeter);
    }

    @Test
    void testCalculateAreaForTriangle() {
        double area = mathService.calculateArea(ShapeType.TRIANGLE, 5);
        assertEquals(12.5, area);
    }

    @Test
    void testCalculatePerimeterForTriangle() {
        double perimeter = mathService.calculatePerimeter(ShapeType.TRIANGLE, 5);
        assertEquals(7.0710678118654755, perimeter);
    }
}
