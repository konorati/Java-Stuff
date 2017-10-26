package Shapes;

public class Sphere extends Shape3D{
    private int radius;

    public Sphere(int radius) {
        checkMeasurement(radius);
        this.radius = radius;
    }

    public double volume() {
        return Math.PI * Math.pow(radius, 3) * 4.0 / 3.0;
    }
}
