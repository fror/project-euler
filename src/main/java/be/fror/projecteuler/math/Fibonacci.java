/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import java.math.BigInteger;

/**
 *
 * @author Olivier Grégoire
 */
public class Fibonacci {

  public static BigInteger fibonacci(int n) {
    return fibonacciDoubling(n);
  }

  static BigInteger fibonacciDoubling(final int n) {
    BigInteger a = BigInteger.ZERO;
    BigInteger b = BigInteger.ONE;
    for (int i = 31 - Integer.numberOfLeadingZeros(n); i >= 0; i--) {
      BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
      BigInteger e = multiply(a, a).add(multiply(b, b));
      a = d;
      b = e;
      if (((n >>> i) & 1) != 0) {
        BigInteger c = a.add(b);
        a = b;
        b = c;
      }
    }
    return a;
  }

  static BigInteger fibonacciMatrix(int n) {
    BigInteger[] matrix = {BigInteger.ONE, BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO};
    return pow(matrix, n)[1];
  }

  // Computes the power of a matrix
  private static BigInteger[] pow(BigInteger[] matrix, int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }
    BigInteger[] result = {BigInteger.ONE, BigInteger.ZERO, BigInteger.ZERO, BigInteger.ONE};
    while (n != 0) {  // Exponentiation by squaring
      if (n % 2 != 0) {
        result = multiply(result, matrix);
      }
      n /= 2;
      matrix = multiply(matrix, matrix);
    }
    return result;
  }

  private static BigInteger[] multiply(BigInteger[] x, BigInteger[] y) {
    return new BigInteger[]{
      multiply(x[0], y[0]).add(multiply(x[1], y[2])),
      multiply(x[0], y[1]).add(multiply(x[1], y[3])),
      multiply(x[2], y[0]).add(multiply(x[3], y[2])),
      multiply(x[2], y[1]).add(multiply(x[3], y[3]))
    };
  }

  static BigInteger fibonacciNaive(int n) {
    BigInteger a = BigInteger.ZERO;
    BigInteger b = BigInteger.ONE;
    for (int i = 0; i < n; i++) {
      BigInteger c = a.add(b);
      a = b;
      b = c;
    }
    return a;
  }

  private static final int CUTOFF = 1536;

  private static BigInteger multiply(BigInteger x, BigInteger y) {
    if (x.bitLength() <= CUTOFF || y.bitLength() <= CUTOFF) {  // Base case
      return x.multiply(y);
    } else {
      int n = Math.max(x.bitLength(), y.bitLength());
      int half = (n + 32) / 64 * 32;  // Number of bits to use for the low part
      BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
      BigInteger xlow = x.and(mask);
      BigInteger ylow = y.and(mask);
      BigInteger xhigh = x.shiftRight(half);
      BigInteger yhigh = y.shiftRight(half);

      BigInteger a = multiply(xhigh, yhigh);
      BigInteger b = multiply(xlow.add(xhigh), ylow.add(yhigh));
      BigInteger c = multiply(xlow, ylow);
      BigInteger d = b.subtract(a).subtract(c);
      return a.shiftLeft(half).add(d).shiftLeft(half).add(c);
    }
  }
}
