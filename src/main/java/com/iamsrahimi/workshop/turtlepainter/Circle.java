package com.iamsrahimi.workshop.turtlepainter;

import java.awt.Point;

public class Circle extends Shape {
    private int radius;

    public Circle(Point location, String color, int borderWidth, int radius) {
        super(location, color, borderWidth);
        this.radius = radius;
    }

    @Override
    public void paint(Canvas canvas) {
        int centerX = location.x + radius;
        int centerY = location.y + radius;
        double innerRadius = Math.max(0, radius - borderWidth);

        for (int y = location.y; y <= location.y + radius * 2; y++) {
            for (int x = location.x; x <= location.x + radius * 2; x++) {
                double distance = Math.sqrt(
                        Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2)
                );

                if (distance <= radius && distance >= innerRadius) {
                    drawPoint(canvas, x, y);
                }
            }
        }
    }
}