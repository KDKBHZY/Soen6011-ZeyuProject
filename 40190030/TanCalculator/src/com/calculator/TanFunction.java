package com.calculator;

/**
 * TanFunction.
 * @author <Zeyu_Huang>
 * @version 1.0
 * @since <pre>7月 31, 2022</pre>
 */
public class TanFunction {
  public TanFunction() {
  }


  /**
   * The Constant PI.
   */
  //  variable start here
  static final double PI = 3.14159265358979;

  /**
   * Gets the rad.
   *
   * @param degree the degree
   * @return the rad
   */

  public static double getRad(double degree) {
    return ((degree * PI) / 180.0);
  }

  public static double getTan(double x) {
    x = getRad(x);
    return x + (x * x * x) / 3 + (2 * (x * x * x * x * x)) / 15 + (17 * (x * x * x * x * x * x * x)) / 315;
  }

  /**.
   * Use periodicity to get valid x
   *
   * @param x degree
   * @return valid degree
   */
  public static double step1(double x) {
    if (x > 180) {
      while (x > 180) {
        x = x - 180;
      }
    } else {
      while (x < 0) {
        x = x + 180;
      }
    }
    System.out.println("change!!!:" + x);
    return x;
  }

  /**.
   * Use the cofunction to calculate tan(x), for x > 45
   *
   * @param x degree
   * @return the value of tan
   */
  public static double step2(double x) {
    x = 180 - x;
    double res = -getTan(x);
    if (x > 45) {
      x = 90 - x;
      res = -1 / getTan(x);

    }
    return res;
  }

  /**.
   * Use symmetry to calculate tan(x), for x > 90
   *
   * @param x degree
   * @return the value of tan
   */
  public static double step3(double x) {
    x = 90 - x;

    return 1 / getTan(x);
  }

  /**.
   * calculate tan in any degree
   *
   * @param x degree
   * @return the value of tan
   */

 public static String calculateTan(double x) {
    double res = 0.0;

    if (x == 90) {
      return "Invalid";
    }
    if (x > 180 || x < 0) {
      x = step1(x);
      System.out.println("x value:" + x);
    }
    if (x > 90) {
      System.out.println(step2(x));
      return String.valueOf(String.format("%.4f", step2(x)));
    }
    if (x > 45) {
      System.out.println(step3(x));
      return String.valueOf(String.format("%.4f", step3(x)));
    }
    if (x > 22.5) {
      x = x / 2;
      res = (2 * getTan(x)) / (1 - getTan(x) * getTan(x));
      return String.valueOf(String.format("%.4f", res));
    }
    if (x >= 0) {
      res = getTan(x);
      return String.valueOf(String.format("%.4f", res));
    }
    return "invalid";
 }
}
