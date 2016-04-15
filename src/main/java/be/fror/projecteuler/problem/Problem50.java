/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

/**
 * The prime 41, can be written as the sum of six consecutive primes: 41 = 2 + 3 + 5 + 7 + 11 + 13
 *
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms,
 * and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 *
 *
 * @author Olivier Grégoire
 */
public class Problem50 extends AbstractProblem {

  @Override
  public Object solve() {
    final int N = 1_000_000;
    int[] primes = Primes.sieve(N / 200);
    int sum = 0;
    int maxIndex = 0;
    while (maxIndex < primes.length && sum < N) {
      sum += primes[maxIndex++];
    }
    sum -= primes[--maxIndex];
    for (int reduction = 1; reduction < maxIndex; reduction++) {
      for (int left = reduction, right = 0; left >= 0; left--, right++) {
        int s = sum;
        for (int l = 0; l < left; l++) {
          s -= primes[l];
        }
        for (int r = 1; r <= right; r++) {
          s -= primes[primes.length - r];
        }
        if (s <= N && Primes.isPrime(s)) {
          return s;
        }
      }
    }
    return null;
  }
}
