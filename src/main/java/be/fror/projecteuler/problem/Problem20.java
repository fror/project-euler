/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import com.google.common.math.BigIntegerMath;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem20 extends AbstractProblem {

  @Override
  public Object solve() {
    char[] cs = BigIntegerMath.factorial(100).toString().toCharArray();
    int sum = -cs.length * '0';
    for (char c : cs) {
      sum += c;
    }
    return sum;
  }
}
