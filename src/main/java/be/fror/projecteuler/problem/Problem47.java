/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

import java.util.Arrays;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem47 extends AbstractProblem {

  @Override
  public Object solve() {
    final int N = 4;
    final int limit = 1_000_000;
    int[] f = new int[limit];
    for (int n = 4; n < limit; n += 2) {
      f[n]++;
    }
    for (int n = 3, limitSqrt = (int) Math.sqrt(limit); n < limitSqrt; n += 2) {
      if (f[n] != 0) {
        continue;
      }
      for (int m = n + n; m < limit; m += n) {
        f[m]++;
      }
    }
    outer:
    for (int n = 2; n < limit; n++) {
      for (int i = 0; i < N; i++) {
        if (f[n + i] < N) {
          continue outer;
        }
      }
      return n;
    }
    return null;
  }
}
