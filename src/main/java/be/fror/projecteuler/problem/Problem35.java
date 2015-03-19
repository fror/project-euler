/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem35 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1000000;

    int[] powersOf10 = new int[(int) (Math.log10(N))];
    for (int i = 0, p = 1; i < powersOf10.length; i++, p *= 10) {
      powersOf10[i] = p;
    }
    int[] validDigits = {1, 3, 7, 9}; // Simple reasoning about the possible last digit of a prime number above 100.

    int count = 13; // the question states this.

    for (int pow = 3; pow <= powersOf10.length; pow++) { // Start from 3 as the question gives the number for pow <= 2.
      int start = 0, end = 1 << (pow << 1);
      // cache of primes
      boolean[] primes = new boolean[end];
      outer:
      for (int quaterit = start; quaterit < end; quaterit++) { // for each combination of valid digits repeated 'pow' times
        int number = 0; // the actual number (to test the primality)
        for (int i = 0; i < pow; i++) {
          number += powersOf10[i] * validDigits[(quaterit >> (i << 1)) & 3];
        }
        if (!(primes[quaterit] = Primes.isPrime(number))) {
          continue;
        }
        for (int i = 2, l = pow << 1; i < l; i += 2) {
          // Shift the 'quaterits'
          int n = (quaterit >> i) | ((quaterit & ((1 << i) - 1)) << l - i);

          // Make sure that n has already been tested and is prime
          if (n >= quaterit || !primes[n]) {
            continue outer;
          }
        }
        // A complete sequence was found. Add all of the numbers at once.
        count += pow;
      }
    }
    return count;
  }
}
