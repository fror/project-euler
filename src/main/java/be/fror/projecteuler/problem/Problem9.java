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
public class Problem9 extends AbstractProblem {

  @Override
  public Object solve() {
    final int limit = 1000;
    int[] squares = new int[limit + 1];
    for (int i = 1; i <= limit; i++) {
      squares[i] = i * i;
    }
    for (int a = limit / 3; a >= 1; a--) {
      for (int b = a + 1, c = limit - a - b; b < c; b++, c--) {
        // asssert a + b + c == l;
        if (squares[a] + squares[b] == squares[c]) {
          return a * b * c;
        }
      }
    }
    return null;
  }

}
