package com.iamsrahimi.workshop.turtlepainter;

import java.awt.Point;
import java.io.IOException;
import java.util.Scanner;

public class TurtlePainterApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter canvas width: ");
        int width = input.nextInt();

        System.out.print("Enter canvas height: ");
        int height = input.nextInt();

        Canvas canvas = new Canvas(width, height);
        boolean running = true;

        while (running) {
            System.out.println("\nHome Screen");
            System.out.println("1) Add Shape");
            System.out.println("2) Save Painting");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();

            if (choice == 1) {
                addShape(input, canvas);
                canvas.display();
            } else if (choice == 2) {
                try {
                    canvas.saveToFile("painting.txt");
                    System.out.println("Painting saved as painting.txt");
                } catch (IOException e) {
                    System.out.println("Could not save the painting.");
                }
            } else if (choice == 0) {
                running = false;
            } else {
                System.out.println("Please choose 1, 2, or 0.");
            }
        }

        input.close();
        System.out.println("Goodbye!");
    }

    private static void addShape(Scanner input, Canvas canvas) {
        System.out.println("\nWhich shape?");
        System.out.println("1) Square");
        System.out.println("2) Circle");
        System.out.println("3) Triangle");
        System.out.print("Choose a shape: ");

        int shapeChoice = input.nextInt();

        System.out.print("Enter x location: ");
        int x = input.nextInt();

        System.out.print("Enter y location: ");
        int y = input.nextInt();

        System.out.print("Enter border width: ");
        int borderWidth = input.nextInt();

        System.out.print("Enter color (red, blue, green, or black): ");
        String color = input.next().toLowerCase();

        Point location = new Point(x, y);
        Shape shape;

        if (shapeChoice == 1) {
            System.out.print("Enter square side length: ");
            int sideLength = input.nextInt();
            shape = new Square(location, color, borderWidth, sideLength);
        } else if (shapeChoice == 2) {
            System.out.print("Enter circle radius: ");
            int radius = input.nextInt();
            shape = new Circle(location, color, borderWidth, radius);
        } else if (shapeChoice == 3) {
            System.out.print("Enter triangle side length: ");
            int sideLength = input.nextInt();
            shape = new Triangle(location, color, borderWidth, sideLength);
        } else {
            System.out.println("That shape choice is not available.");
            return;
        }

        canvas.addShape(shape);
    }
}