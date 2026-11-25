package com.iamsrahimi.workshop.turtlepainter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Canvas {
    private char[][] drawing;

    public Canvas(int width, int height) {
        drawing = new char[height][width];
        clear();
    }

    public void setPoint(int x, int y, char symbol) {
        if (y >= 0 && y < drawing.length
                && x >= 0 && x < drawing[y].length) {
            drawing[y][x] = symbol;
        }
    }

    public void addShape(Shape shape) {
        shape.paint(this);
    }

    public void clear() {
        for (int y = 0; y < drawing.length; y++) {
            for (int x = 0; x < drawing[y].length; x++) {
                drawing[y][x] = ' ';
            }
        }
    }

    public void display() {
        for (char[] row : drawing) {
            System.out.print("|");
            System.out.print(row);
            System.out.println("|");
        }
    }

    public void saveToFile(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (char[] row : drawing) {
                writer.write("|");
                writer.write(row);
                writer.write("|");
                writer.newLine();
            }
        }
    }
}