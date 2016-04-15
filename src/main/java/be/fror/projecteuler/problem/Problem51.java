/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;

/**
 *
 *
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
 * values: 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the
 * first example having seven primes among the ten generated numbers, yielding the family: 56003,
 * 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this
 * family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 *
 *
 *
 * @author Olivier Grégoire
 */
public class Problem51 extends AbstractProblem {

  @Override
  public Object solve() {
    int[] primes = Primes.sieve();
    char[] ca = new char[]{'0', '1', '2'};
    for (int prime : primes) {
      String primeStr = Integer.toString(prime);
      for (int i = 0; i < ca.length; i++) {
        if (primeStr.indexOf(ca[i]) != -1 && primeSubstitues(primeStr, ca[i]) >= 8) {
          return primeStr;
        }
      }
    }
    return null;
  }

  private static int primeSubstitues(String primeStr, char start) {
    int count = 1;
    for (int i = start + 1; i <= '9'; i++) {
      if (Primes.isPrime(Integer.parseInt(primeStr.replace(start, (char) i)))) {
        count++;
      }
    }
    return count;
  }
}
