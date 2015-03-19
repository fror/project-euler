/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 extends AbstractProblem {

  @Override
  public Object solve() {
    int MAX = 999;
    int n3 = MAX / 3, n5 = MAX / 5, n15 = MAX / 15;
    return ((n3 * (n3 + 1) * 3) + (n5 * (n5 + 1) * 5) - (n15 * (n15 + 1) * 15)) / 2;
  }
}
