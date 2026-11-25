package com.iamsrahimi.workshop.turtlepainter;

import java.awt.Point;

public class Triangle extends Shape {
    private int sideLength;

    public Triangle(Point location, String color, int borderWidth, int sideLength) {
        super(location, color, borderWidth);
        this.sideLength = sideLength;
    }

    @Override
    public void paint(Canvas canvas) {
        int height = (int) (Math.sqrt(3) / 2 * sideLength);

        int topX = location.x + sideLength / 2;
        int topY = location.y;
        int leftX = location.x;
        int bottomY = location.y + height;
        int rightX = location.x + sideLength;

        drawLine(canvas, topX, topY, leftX, bottomY);
        drawLine(canvas, leftX, bottomY, rightX, bottomY);
        drawLine(canvas, rightX, bottomY, topX, topY);
    }
}