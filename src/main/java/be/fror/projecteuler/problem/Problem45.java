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
public class Problem45 extends AbstractProblem {

  @Override
  public Object solve() {
    long np = 143, nh = 165;
    while(true) {
      nh++;
      long h = nh * (2 * nh - 1);
      long p;
      do {
        p = np * (3 * np - 1) / 2;
        np++;
      } while (p < h);
      if (p == h) {
        return p;
      }
    }
  }
}
