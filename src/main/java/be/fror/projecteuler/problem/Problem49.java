/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

import java.util.Arrays;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is
 * unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers
 * are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this
 * property, but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 *
 * @author Olivier Grégoire
 */
public class Problem49 extends AbstractProblem {

  @Override
  public Object solve() {
    int[] primes = Primes.sieve(10000);
    int[] pow10 = new int[10];
    long[] stat = new long[10000];
    pow10[0] = 1;
    for (int i = 1; i < pow10.length; i++) {
      pow10[i] = pow10[i - 1] * 10;
    }
    for (int pi = 0; pi < primes.length; pi++) {
      int p = primes[pi];
      while (p > 0) {
        int pn = p / 10;
        stat[primes[pi]] += pow10[p - pn * 10];
        p = pn;
      }
    }
    for (int pi = 0; pi < primes.length; pi++) {
      int i = primes[pi];
      if (i < 1000) {
        continue;
      }
      for (int pj = pi + 1; pj < primes.length; pj++) {
        int j = primes[pj];
        int k = j * 2 - i;
        if (k > 10000) {
          break;
        }
        if (stat[i] == stat[j] && stat[i] == stat[k] && i != 1487) {
          return new StringBuilder(12).append(i).append(j).append(k);
        }
      }
    }
    return null;
  }
}
