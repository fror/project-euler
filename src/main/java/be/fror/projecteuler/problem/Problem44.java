/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import java.util.Arrays;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem44 extends AbstractProblem {

  @Override
  public Object solve() {
    int[] p = new int[3000];
    for (int i = 0; i < p.length; i++) {
      p[i] = i * (i * 3 - 1) / 2;
    }
    int n = Integer.MAX_VALUE;
    for (int i = 1; i < p.length; i++) {
      for (int j = 1; j < i; j++) {
        if (Arrays.binarySearch(p, p[i] - p[j]) >= 0 && Arrays.binarySearch(p, p[i] + p[j]) >= 0) {
          return p[i] - p[j];
        }
      }
    }
    return null;
  }
}
