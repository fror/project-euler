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
public class Problem46 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 100;
    int[] primes = Primes.sieve(N * N);
    int[] doubledSquares = new int[N];
    for (int i = 0; i < doubledSquares.length; i++) {
      doubledSquares[i] = 2 * i * i;
    }
    for (int n = 3, npi = 1;; n += 2) {
      if (n == primes[npi]) {
        npi++;
        continue;
      }
      boolean found = false;
      for (int dsi = 1; doubledSquares[dsi] < n; dsi++) {
        if (Arrays.binarySearch(primes, n - doubledSquares[dsi]) >= 0) {
          found = true;
          break;
        }
      }
      if (!found) {
        return n;
      }
    }
  }
}
