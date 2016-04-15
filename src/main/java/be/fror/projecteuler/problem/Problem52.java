/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
 * but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 *
 * @author Olivier Grégoire
 */
public class Problem52 extends AbstractProblem {

  @Override
  public Object solve() {
    int[] pow10 = new int[10];
    pow10[0] = 1;
    for (int i = 1; i < pow10.length; i++) {
      pow10[i] = pow10[i - 1] * 10;
    }
    for (int i = 0; i < pow10.length - 1; i++) {
      for (int n = pow10[i], limit = pow10[i + 1] / 6; n <= limit; n++) {
        long statN = 0L;
        int xN = n;
        while (xN > 0) {
          int q = xN / 10;
          statN += pow10[xN - q * 10];
          xN = q;
        }
        boolean found = true;
        for (int mul = n + n, limitMul = n * 6; mul <= limitMul; mul += n) {
          long statMul = 0L;
          int xMul = mul;
          while (xMul > 0) {
            int q = xMul / 10;
            statMul += pow10[xMul - q * 10];
            xMul = q;
          }
          if (statN != statMul) {
            found = false;
            break;
          }
        }
        if (found) {
          return n;
        }
      }
    }
    return null;
  }
}
