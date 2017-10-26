package Shapes;

public class Cube extends Shape3D{
    private int length;

    public Cube(int length) {
        checkMeasurement(length);
        this.length = length;
    }

    public double volume() {
        return Math.pow(length, 3);
    }
}
