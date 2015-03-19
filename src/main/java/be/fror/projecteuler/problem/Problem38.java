/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem38 extends AbstractProblem {

  @Override
  public Object solve() {
    outer:
    for (int n = 9876;; n--) {
      int pandigital = 2;
      for (int x = n, y = n * 2; x > 0; x /= 10, y /= 10) {
        int bits = (1 << x % 10) | (1 << y % 10);
        if ((pandigital & bits) != 0) {
          continue outer;
        }
        pandigital |= bits;
      }
      if (pandigital == 1022) {
        return n * 100000 + 2 * n;
      }
    }
  }
}
