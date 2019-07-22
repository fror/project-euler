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
    for (int sumOfDigits = 3; sumOfDigits <= max; sumOfDigits++) {
      int sum = 0;
      for (int x = sumOfDigits; x > 0 && sum <= sumOfDigits; x /= 10) {
        sum += factorials[x % 10];
      }
      if (sum == sumOfDigits) {
        result += sum;
      }
    }
    return result;
  }

}
