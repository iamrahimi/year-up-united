package com.iamsrahimi.workshop.turtlepainter;

import java.awt.Point;

public abstract class Shape implements Paintable {
    protected Point location;
    protected String color;
    protected int borderWidth;

    public Shape(Point location, String color, int borderWidth) {
        this.location = location;
        this.color = color;
        this.borderWidth = borderWidth;
    }

    protected char getSymbol() {
        switch (color.toLowerCase()) {
            case "red":
                return 'R';
            case "blue":
                return 'B';
            case "green":
                return 'G';
            default:
                return '#';
        }
    }

    protected void drawPoint(Canvas canvas, int x, int y) {
        char symbol = getSymbol();
        int thickness = Math.max(1, borderWidth);
        int start = -(thickness - 1) / 2;
        int end = thickness / 2;

        for (int dy = start; dy <= end; dy++) {
            for (int dx = start; dx <= end; dx++) {
                canvas.setPoint(x + dx, y + dy, symbol);
            }
        }
    }

    protected void drawLine(Canvas canvas, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int stepX = x1 < x2 ? 1 : -1;
        int stepY = y1 < y2 ? 1 : -1;
        int error = dx - dy;

        while (true) {
            drawPoint(canvas, x1, y1);

            if (x1 == x2 && y1 == y2) {
                break;
            }

            int twiceError = 2 * error;

            if (twiceError > -dy) {
                error -= dy;
                x1 += stepX;
            }

            if (twiceError < dx) {
                error += dx;
                y1 += stepY;
            }
        }
    }
}