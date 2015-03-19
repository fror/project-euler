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
public class Problem24 extends AbstractProblem {

  @Override
  public Object solve() {
    char[] values = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    final int N = 1_000_000;
    int[] factorials = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880}; // go as far as values.length
    for (int len = values.length - 1, from = 0, totalPerms = N - 1, perms = factorials[len - from];
        from < len;
        from++, totalPerms %= perms, perms = factorials[len - from]) {
      int to = from + totalPerms / perms;
      char tmp = values[to];
      System.arraycopy(values, from, values, from + 1, to - from);
      values[from] = tmp;
    }
    return new String(values);
  }
}
