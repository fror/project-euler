/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

/**
 *
 * @author Olivier Grégoire
 */
public class IntMath2 {

  /**
   *
   * @param base must be positive
   * @param exp must be positive
   * @param mod must be positive and strictly less than 46342
   * @return
   */
  public static int modPow(int base, int exp, int mod) {
    int result = 1;
    base %= mod;
    while (exp > 0) {
      if ((exp & 1) == 1) {
        result = (result * base) % mod;
      }
      exp >>= 1;
      base = (base * base) % mod;
    }
    return result;
  }
}
