/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem12 extends AbstractProblem {

  @Override
  public Object solve() {
    final int N = 500;
    for (int n = 1;; n += 2) {
      int cd = countDivisors((n + 1) >> 1);
      if (countDivisors(n) * cd > N) {
        return n * (n + 1) >> 1;
      }
      if (cd * countDivisors(n + 2) > N) {
        return (n + 1) * (n + 2) >> 1;
      }
    }
  }

  final static int[] primes = { 2, 3, 5, 7, 11, 13, 17 }; /*Primes.basicSieve(20)*/

  public int countDivisors(int number) {
    int count = 1;
    for (int i = 0; i < primes.length; i++) {
      final int p = primes[i];
      if (p > number) {
        break;
      }
      int quotient = number / p;
      if (number == p * quotient) { // if (number % p == 0)
        int pn = 2;
        number = quotient;
        for (int n = quotient, q = n / p; n == p * q; n = q, q = n / p) { // while (number %= p == 0)
          pn++;
          number = q;
        }
        count *= pn;
      }
    }
    return count;
  }
}
