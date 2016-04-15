/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 * @author Olivier Grégoire
 */
public class Problem53 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 100;
    int THRESHOLD = 1000000;

    int g = 0;
    for (int k = 0, n = N, j = N, c = 1; k < (n >> 1);) {
      if (c * j / (k + 1) > THRESHOLD) {
        g += n - (k << 1) - 1;
        c = c * j-- / n--;
      } else {
        c = c * j-- / ++k;
      }
    }
    return g;

  }
}
