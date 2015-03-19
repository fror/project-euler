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
public class Problem21 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 10000;
    int[] d = new int[N];
    int sum = 0;
    for (int i = 1; i < N; i++) {
      for (int j = i << 1; j < N; j += i) {
        d[j] += i;
      }
      if (d[i] < i && i == d[d[i]]) {
        sum += i + d[i];
      }
    }
    return sum;
  }
}
