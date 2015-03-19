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
public class Problem7 extends AbstractProblem {

  @Override
  public Integer solve() {
    return Primes.sieve(200000)[10000];
  }

}
