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
public class Problem31 extends AbstractProblem {

  @Override
  public Object solve() {
    int N = 200;
    int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    int[] ways = new int[N + 1];
    ways[0] = 1;

    for (int coin : coins) {
      for (int j = coin; j <= N; j++) {
        ways[j] += ways[j - coin];
      }
    }

    return ways[N];
  }
}
