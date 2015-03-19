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
public class Problem23 extends AbstractProblem {

  @Override
  public Object solve() {
    final int N = 28123;
    int[] div = new int[N + 1];
    int[] abundants = new int[N + 1];
    int abundantsSize = 0;
    boolean[] sumsOfAbundants = new boolean[N + 1];
    int totalSumOfAbundants = (N * (N + 1)) / 2;
    for (int i = 1; i <= N; i++) {
      for (int j = i << 1; j < N; j += i) {
        div[j] += i;
      }
      if (div[i] > i) { // i is abundant
        abundants[abundantsSize++] = i;
        for (int j = 0, soa; j < abundantsSize && (soa = i + abundants[j]) <= N; j++) {
          if (!sumsOfAbundants[soa]) {
            totalSumOfAbundants -= soa;
            sumsOfAbundants[soa] = true;
          }
        }
      }
    }
    return totalSumOfAbundants;
  }
}
