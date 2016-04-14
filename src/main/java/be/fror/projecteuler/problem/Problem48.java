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
public class Problem48 extends AbstractProblem {

  @Override
  public Object solve() {
    final long mod = 10_000_000_000L;
    long sumMod = 0L;
    for (int n = 1; n <= 1000; n++) {
      sumMod = (sumMod + modPow(n, n, mod)) % mod;
    }
    return sumMod;
  }

  long modPow(long base, int exp, long mod) {
    base %= mod;
    long result = 1;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * base) % mod;
      }
      base = (base * base) % mod;
      exp >>= 1;
    }
    return result;
  }
}
