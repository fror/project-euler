/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Tools;


/**
 *
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */
public class Problem4 extends AbstractProblem {

  @Override
  public Object solve() {
    int greatestPalindromic = Integer.MIN_VALUE;
    int stop = Integer.MIN_VALUE;
    for (int i = 999, sqi = i * i; stop < i; i--, sqi -= (i + i - 1)) {
      for (int product = i * 999; sqi <= product && greatestPalindromic < product; product -= i) {
        if (Tools.isPalindromic(product)) {
          greatestPalindromic = product;
          stop = product / 999;
          break;
        }
      }
    }
    return greatestPalindromic;
  }

}
