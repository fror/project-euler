/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import static java.lang.Math.floor;
import static java.lang.Math.log;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem29 extends AbstractProblem {

  @Override
  public Object solve() {

    int N = 100;

    int maxPow = (int) floor(log(N) / log(2));
    int[] dupesPerPow = new int[maxPow + 1];
    int[] numOfPow = new int[maxPow + 1];
    int totDupes = 0;

    // Step one: find dupes per power.
    for (int a = 2; a <= maxPow; a++) {
      boolean[] powOverlap = new boolean[N + 1];
      int count = 0;
      for (int k = 1; k < a; k++) {
        int spacing = k / IntMath.gcd(k, a);
        for (int n = 0, l = k * N / a; n <= l; n += spacing) {
          if (!powOverlap[n]) {
            count++;
            powOverlap[n] = true;
          }
        }
      }
      dupesPerPow[a] = count;
    }

    // Step two: find actual number of powers.
    int sqrtN = IntMath.sqrt(N, RoundingMode.FLOOR);
    boolean[] powersNotToRepeat = new boolean[sqrtN + 1];
    for (int i = 2; i <= sqrtN; i++) {
      if (!powersNotToRepeat[i]) {
        for (int p = 2, pow = i * i; pow <= N; p++, pow *= i) {
          numOfPow[p]++;
          if (pow <= sqrtN) {
            powersNotToRepeat[pow] = true;
          }
        }
      }
    }

    for (int p = 2; p <= maxPow; p++) {
      totDupes += numOfPow[p] * dupesPerPow[p];
    }
    return (N - 1) * (N - 1) - totDupes;
  }
}
