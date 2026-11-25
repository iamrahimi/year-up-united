package com.iamsrahimi.workshop.turtlepainter;

import java.awt.Point;

public class Square extends Shape {
    private int sideLength;

    public Square(Point location, String color, int borderWidth, int sideLength) {
        super(location, color, borderWidth);
        this.sideLength = sideLength;
    }

    @Override
    public void paint(Canvas canvas) {
        int left = location.x;
        int top = location.y;
        int right = left + sideLength - 1;
        int bottom = top + sideLength - 1;

        for (int x = left; x <= right; x++) {
            drawPoint(canvas, x, top);
            drawPoint(canvas, x, bottom);
        }

        for (int y = top; y <= bottom; y++) {
            drawPoint(canvas, left, y);
            drawPoint(canvas, right, y);
        }
    }
}