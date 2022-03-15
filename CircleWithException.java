package com.T8;

import java.util.Scanner;

public class CircleWithException {

    private double radius;
    private final static double PI = 3.14;

    public static void main(String[] args) {
        // Creating dummy circle
        CircleWithException circle = new CircleWithException();
        Scanner scanner = new Scanner(System.in);

        System.out.print("What is the radius: ");
        double input = scanner.nextDouble();
        try {
            circle.setRadius(input);
        } catch (IllegalArgumentException e ) {
            System.out.println("Error: Radius less than 0");
            return;
        }

        try {
            System.out.println("Cicle Area:" + circle.getArea());
        } catch (Exception e) {
            System.out.println("Error: Area is greater than 1000");
        }

    }

    public double getArea() throws Exception {
        double area = PI * radius * radius;
        if (area > 1000) throw new Exception("Area is greater than 1000");
        return area;
    }

    public double getDiameter() {
        return PI * radius * 2;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException {
        if (radius <= 0) throw new IllegalArgumentException("Radius less than 0");
        this.radius = radius;
    }
}
