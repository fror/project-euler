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
public class Problem27 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1000;
    int n = (int) ((Math.sqrt(4 * N - 163) - 1) / 2);
    return (n * n + n + 41) * (-(2 * n + 1));
  }
}
