package Shapes;

public class Tetrahedron extends Shape3D{
    private int edge;

    public Tetrahedron(int edge) {
        checkMeasurement(edge);
        this.edge = edge;
    }

    public double volume() {
        return Math.pow(edge, 3) / (6 * Math.sqrt(2));
    }
}
