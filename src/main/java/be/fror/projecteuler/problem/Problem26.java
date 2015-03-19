/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.IntMath2;
import be.fror.projecteuler.math.Primes;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem26 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1000;
    int[] primes = Primes.sieve(N);
    int maxK = Integer.MIN_VALUE;
    int maxPrime = Integer.MIN_VALUE;
    for (int i = primes.length - 1; i >= 0; i--) {
      int prime = primes[i];
      if (prime < maxK) {
        break;
      }
      for (int k = 1; k < prime; k++) {
        if (IntMath2.modPow(10, k, prime) == 1) {
          if (k > maxK) {
            maxK = k;
            maxPrime = prime;
          }
          break;
        }
      }
    }
    return maxPrime;
  }
}
