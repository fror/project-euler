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
public class Problem10 extends AbstractProblem {

  @Override
  public Object solve() {
    long sum = 0L;
    for (long prime : Primes.sieve(2000000)) {
      sum += prime;
    }
    return sum;
  }

}
