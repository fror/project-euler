/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import static java.lang.Math.ceil;
import static java.lang.Math.log10;
import static java.lang.Math.sqrt;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem25 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1000;
    double sqrt5 = sqrt(5);
    return (int) ceil((N - 1 + log10(sqrt5)) / log10((1 + sqrt5) / 2));
  }
}
