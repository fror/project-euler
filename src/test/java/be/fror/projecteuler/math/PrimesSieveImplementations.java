/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

/**
 *
 * @author Olivier Grégoire <https://github.com/fror>
 */
class PrimesSieveImplementations {

  // Caliper results: https://microbenchmarks.appspot.com/runs/e570704f-d091-4e16-baad-4d0f1175fe01
  static boolean[] sieveOfEratosthenes(int upperBound) {
    final int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
    boolean[] sieve = new boolean[upperBound + 1];
    for (int candidate = 2; candidate <= upperBoundSquareRoot; candidate++) {
      if (!sieve[candidate]) {
        for (int composite = candidate * candidate; composite <= upperBound; composite += candidate) {
          sieve[composite] = true;
        }
      }
    }
    return sieve;
  }

  static boolean[] sieveOfAtkin(int upperBound) {
    final int upperBoundSquareRoot = (int) Math.sqrt(upperBound);
    boolean[] sieve = new boolean[upperBound + 1];
    sieve[2] = true;
    sieve[3] = true;

    for (int x = 1, xsq = 1; x <= upperBoundSquareRoot; x++, xsq += x + x - 1) {
      for (int y = 1, ysq = 1; y <= upperBoundSquareRoot; y++, ysq += y + y - 1) {
        int n = 4 * xsq + ysq;
        if (n <= upperBound) {
          int nmod12 = n % 12;
          if (nmod12 == 1 || nmod12 == 5) {
            sieve[n] = !sieve[n];
          }
        }
        n = 3 * xsq + ysq;
        if (n <= upperBound && (n % 12 == 7)) {
          sieve[n] = !sieve[n];
        }
        n = 3 * xsq - ysq;
        if (x > y && n <= upperBound && (n % 12 == 11)) {
          sieve[n] = !sieve[n];
        }
      }
    }
    for (int n = 5; n <= upperBoundSquareRoot; n++) {
      if (sieve[n]) {
        final int x = n * n;
        for (int i = x; i <= upperBound; i += x) {
          sieve[i] = false;
        }
      }
    }

    return sieve;
  }

  private static final int[] sequence = {2, 4};
  private static final double sqrt3 = Math.sqrt(3);

  static boolean[] sieveOfAtkin_optimized(int upperBound) {
    double upperBoundSqrt = Math.sqrt(upperBound);
    boolean[] sieve = new boolean[upperBound + 1];
    for (int x = 1, s = (int) (Math.ceil(upperBoundSqrt / 2)); x < s; x++) {
      int k1 = 4 * x * x;
      if (x % 3 == 0) {
        for (int y = 1, k = k1 + 1, i = 0; k < upperBound; y += sequence[i ^= 1], k = k1 + y * y) {
          sieve[k] = !sieve[k];
        }
      } else {
        for (int y = 1, k = k1 + 1; k < upperBound; y += 2, k = k1 + y * y) {
          sieve[k] = !sieve[k];
        }
      }
    }
    for (int x = 1, s = (int) (Math.ceil(upperBoundSqrt / sqrt3)); x < s; x += 2) {
      int k1 = 3 * x * x;
      for (int y = 2, k = k1 + 4, i = 1; k < upperBound; y += sequence[i ^= 1], k = k1 + y * y) {
        sieve[k] = !sieve[k];
      }
    }
    for (int x = 1, s = (int) upperBoundSqrt; x < s; x++) {
      int k1 = 3 * x * x;
      if ((x & 1) == 0) {
        for (int y = 1, k = k1 - 1, i = 0; y < x; y += sequence[i ^= 1], k = k1 - y * y) {
          if (k < upperBound) {
            sieve[k] = !sieve[k];
          }
        }
      } else {
        for (int y = 2, k = k1 - 4, i = 1; y < x; y += sequence[i ^= 1], k = k1 - y * y) {
          if (k < upperBound) {
            sieve[k] = !sieve[k];
          }
        }
      }
    }
    sieve[2] = true;
    sieve[3] = true;
    for (int n = 5, s = ((int) upperBoundSqrt) + 1; n <= s; n++) {
      if (sieve[n]) {
        int nsq = n * n;
        for (int k = nsq; k < upperBound; k += nsq) {
          sieve[k] = false;
        }
      }
    }
    return sieve;
  }

}
