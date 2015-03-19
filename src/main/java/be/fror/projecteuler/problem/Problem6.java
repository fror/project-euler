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
public class Problem6 extends AbstractProblem {

  @Override
  public Object solve() {
    final int from = 1;
    final int to = 100;
    int squareOfSum = (to * (to + 1) - from * (from - 1)) / 2;
    squareOfSum *= squareOfSum;
    int sumOfSquares = 0;
    for (int x = from; x <= to; x++) {
      sumOfSquares += x * x;
    }
    return squareOfSum - sumOfSquares;
  }
}
