package com.calculator;

import com.calculator.TanFunction;
import org.junit.Test;
import java.lang.Math;
import static org.junit.Assert.*;

/**
* TanFunction Tester.
*
* @author <Zeyu Huang>
* @since <pre>7月 31, 2022</pre>
* @version 1.0
*/
public class TanFunctionTest {

TanFunction tanfunc = new TanFunction();
/**
*
* Method: getRad(double degree)
*
*/
@Test
public void testGetRad() throws Exception {
       double res = TanFunction.getRad(45);
       String res1 = String.valueOf(String.format("%.4f",res));
       String res2 = String.valueOf(String.format("%.4f",Math.toRadians(45)));
       assertEquals(res1,res2);
}

/**
*
* Method: calculateTan(double x in degree)
*
*/
@Test
public void testCalculateTan() throws Exception {
    String res1 = TanFunction.calculateTan(45);
    String res2 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(45))));
    assertEquals(res1,res2);
    String res3 = TanFunction.calculateTan(195);
    String res4 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(195))));
    assertEquals(res3,res4);
    String res5 = TanFunction.calculateTan(85);
    String res6 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(85))));
    assertEquals(res5,res6);
    String res7 = TanFunction.calculateTan(-10);
    String res8 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(-10))));
    assertEquals(res7,res8);
    String res9 = TanFunction.calculateTan(110);
    String res10 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(110))));
    assertEquals(res9,res10);
    String res11 = TanFunction.calculateTan(90);
    String res12 = "Invalid";
    assertEquals(res11,res12);
    String res13 = TanFunction.calculateTan(180);
    String res14 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(180))));
    assertEquals(res13,res14);
    String res15 = TanFunction.calculateTan(0);
    String res16 = String.valueOf(String.format("%.4f",Math.tan(Math.toRadians(0))));
    assertEquals(res15,res16);
}


} 
