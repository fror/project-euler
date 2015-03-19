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
public class Problem28 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 1001;
    int a = (N - 1) / 2;
    return 1 + (16 * a * a * a + 30 * a * a + 26 * a) / 3;
  }
}
