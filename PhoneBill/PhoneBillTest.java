package Shapes;

import org.testng.Assert;
import org.testng.annotations.Test;
import Shapes.PhoneBill;

public class PhoneBillTest {

    @Test
    public void phoneBillTest1() {
        String billString = "00:01:07,400-234-090\n00:05:01,701-080-080\n00:05:00,400-234-090";
        PhoneBill pb = new PhoneBill(billString);
        Assert.assertEquals(pb.calculateBill(), 900);
    }

    @Test
    public void phoneBillTest2() {
        String billString = "00:01:32,400-234-090\n00:05:01,701-080-080\n00:05:00,643-777-213";
        PhoneBill pb = new PhoneBill(billString);
        Assert.assertEquals(pb.calculateBill(), 1026);
    }

    @Test
    public void phoneBillTest3() {
        String billString = "01:00:00,400-234-090\n03:05:01,701-080-080";
        PhoneBill pb = new PhoneBill(billString);
        Assert.assertEquals(pb.calculateBill(), 9000);
    }

}