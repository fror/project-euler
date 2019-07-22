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
public class Problem45 extends AbstractProblem {

  @Override
  public Object solve() {
    long p = 7;
    long s = 2;
    {
      long tmp = p;
      p = 7 * p + 24 * s;
      s = 7 * s + 2 * tmp;
    }
    long index = p * p + 5 * p * s + 6 * s * s;
    return index * (index * 2 - 1);
  }

}
