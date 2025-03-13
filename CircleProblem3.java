package org.example;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class CircleProblem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of points: ");
        int pointsNumber = sc.nextInt();

        Random random = new Random();

        PointGenerator generatePoint = () -> new Point(-1 + 2 * random.nextDouble(),-1 + 2 * random.nextDouble());

        InsideCircle checkInsideCircle = (point) ->
                (Math.pow(point.getXValue(), 2) + Math.pow(point.getYValue(), 2)) <= 1;

        int insideCircleCount = IntStream.range(0, pointsNumber)
                .mapToObj(i -> generatePoint.generate())
                .filter(checkInsideCircle::isInside)
                .mapToInt(point -> checkInsideCircle.isInside(point) ? 1 : 0)
                .sum();

        double piEstimate = 4.0 * ((double) insideCircleCount / pointsNumber);
        System.out.println("Estimated Pi: " + piEstimate);
    }

    @FunctionalInterface
    interface PointGenerator {
        Point generate();
    }

    @FunctionalInterface
    interface InsideCircle {
        boolean isInside(Point point);
    }
}

class Point {
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getXValue() {
        return x;
    }

    public double getYValue() {
        return y;
    }
}