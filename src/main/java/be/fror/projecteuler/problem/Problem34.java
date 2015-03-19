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
public class Problem34 extends AbstractProblem {

  @Override
  public Object solve() {
    int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    final int max = 50000;
    int result = 0;
    for (int i = 3; i <= max; i++) {
      int sum = 0;
      for (int n = i; n > 0; n /= 10) {
        sum += factorials[n % 10];
        if (sum > i) {
          break;
        }
      }
      if (sum == i) {
        result += sum;
      }
    }
    return result;
  }

}
