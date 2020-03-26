package ru.stqa.pft.sandbox;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public static double distance (Point p1, Point p2){
        double catet1sq = (p2.x - p1.x)*(p2.x - p1.x);
        double catet2sq = (p2.y - p1.y)*(p2.y - p1.y);

        double d = Math.sqrt(catet1sq + catet2sq);
        return d;

    }


}
