package Shapes;

public abstract class Shape3D {

    abstract double volume();

    /* Note: This function will not work for very large numbers
            or if you want a very large number of decimal spaces. */
    public double round(double num, double places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        num = num * factor;
        long tmp = Math.round(num);
        return (double) tmp / factor;
    }

    public void checkMeasurement(int measurement) {
        if(measurement < 1) {
            throw new IllegalArgumentException("Measurement must be a positive integer");
        }
    }
}
