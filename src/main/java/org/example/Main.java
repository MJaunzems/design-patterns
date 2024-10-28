package org.example;

import org.example.Facades.ShapeFacade;

public class Main {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();

        shapeFacade.addCircle(5);
        shapeFacade.addSquare(4);
        shapeFacade.addColoredCircle(6, "Red");

        System.out.println("\nDisplaying all shapes:");
        shapeFacade.displayShapes();
    }
}
