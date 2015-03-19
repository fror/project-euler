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
public class Problem39 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1000;
    int[] counts = new int[N + 1];
    for (int i = 1; i <= N; i += 2) {
      for (int j = i + 1;; j++) {
        int n = 4 * j * j + 2 * j * i;
        if (n > N) {
          break;
        }
        for (int perimeter = n; perimeter <= N; perimeter += n) {
          counts[perimeter]++;
        }
      }
    }
    int index = Integer.MIN_VALUE;
    int maxCount = Integer.MIN_VALUE;
    for (int i = 1; i <= N; ++i) {
      if (counts[i] > maxCount) {
        maxCount = counts[i];
        index = i;
      }
    }
    return index;
  }
}
