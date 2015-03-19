/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any
 * remainder.
 * <p>
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */
public class Problem5 extends AbstractProblem {

  @Override
  public Long solve() {
    final int N = 20;
    long n = 1;
    for (long p : Primes.basicSieve(N)) {
      long m = p;
      for (long x = p * p; x < N; x *= p) {
        m = x;
      }
      n *= m;
    }
    return n;
  }

}
