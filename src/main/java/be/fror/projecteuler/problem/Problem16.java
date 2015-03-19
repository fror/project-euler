/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import java.math.BigInteger;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem16 extends AbstractProblem {

  @Override
  public Object solve() {
    char[] c = BigInteger.valueOf(2).pow(1000).toString().toCharArray();
    int sum = '0' * -c.length;
    for (int i = 0; i < c.length; i++) {
      sum += c[i];
    }
    return sum;
  }

}
