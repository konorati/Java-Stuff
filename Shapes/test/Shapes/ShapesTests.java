package Shapes;

import Shapes.Cube;
import Shapes.Shape3D;
import Shapes.Sphere;
import Shapes.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.*;

public class ShapesTests {
    @Test
    public void sphereTest1() {
        Sphere s = new Sphere(1);
        Assert.assertEquals((int)(s.round(s.volume(), 2)*100), (int)(4.19*100));
    }

    @Test
    public void sphereTest2() {
        Sphere s = new Sphere(5);
        Assert.assertEquals((int)(s.round(s.volume(), 2)*100), (int)(523.60*100));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void sphereTestBad() {
        Sphere s = new Sphere(-1);
    }

    @Test
    public void cubeTest1() {
        Cube c = new Cube(1);
        Assert.assertEquals((int)c.round(c.volume(), 2), 1);
    }

    @Test
    public void cubeTest2() {
        Cube c = new Cube(5);
        Assert.assertEquals((int)c.round(c.volume(), 2), 125);

    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void cubeTestBad() {
        Cube c = new Cube(-1);
    }

    @Test
    void tetrahedronTest1() {
        Tetrahedron t = new Tetrahedron(1);
        Assert.assertEquals((int)(t.round(t.volume(), 2)*100), (int)(0.12*100));
    }

    @Test
    public void tetrahedronTest2() {
        Tetrahedron t = new Tetrahedron(5);
        Assert.assertEquals((int)(t.round(t.volume(), 2)*100), (int)(14.73*100));
    }

    @Test(expectedExceptions = {IllegalArgumentException.class})
    public void tetrahedronTestBad() {
        Tetrahedron t = new Tetrahedron(-1);
    }
}