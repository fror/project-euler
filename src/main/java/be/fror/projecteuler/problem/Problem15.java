/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import com.google.common.math.BigIntegerMath;

import java.math.BigInteger;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem15 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 20;
    BigInteger facN = BigIntegerMath.factorial(N);
    BigInteger fac2N = BigIntegerMath.factorial(2 * N);
    return fac2N.divide(facN.multiply(facN));
  }

}
