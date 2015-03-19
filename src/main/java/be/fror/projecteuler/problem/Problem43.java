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
public class Problem43 extends AbstractProblem {

  @Override
  public Object solve() {
    long sum = 0L;
    int[] primes = {2, 3, 5, 7, 11, 13, 17};
    int[][][] mods = new int[primes.length][][];
    for (int i = 0; i < primes.length; i++) {
      final int prime = primes[i];
      boolean[][] mods_b = new boolean[prime][10];
      for (int j = 0, hundreds = 0; j < 10; j++, hundreds += 100) {
        int quotient = hundreds / prime;
        int lastFactor = quotient * prime;
        int mod = hundreds - lastFactor;
        mods_b[mod == 0 ? 0 : (prime + lastFactor) - hundreds][j] = true;
      }
      int[][] x = new int[prime][10];
      for (int j = 0; j < prime; j++) {
        int z = 0;
        for (int k = 0; k < 10; k++) {
          if (mods_b[j][k]) {
            x[j][z++] = k;
          }
        }
        int[] n = new int[z];
        System.arraycopy(x[j], 0, n, 0, z);
        x[j] = n;
      }
      mods[i] = x;
    }
    for (int multipleOf17 = 102; multipleOf17 < 1000; multipleOf17 += 17) {
      boolean[] pandigital = new boolean[10];
      final int d10 = multipleOf17 % 10;
      pandigital[d10] = true;
      final int d9 = multipleOf17 / 10 % 10;
      if (pandigital[d9]) {
        continue;
      }
      pandigital[d9] = true;
      final int d8 = (multipleOf17 / 100);
      if (pandigital[d8]) {
        continue;
      }
      pandigital[d8] = true;

      // Recursive is overrated :P
      for (int d7 : mods[5][(d8 * 10 + d9) % 13]) {
        if (pandigital[d7]) {
          continue;
        }
        pandigital[d7] = true;
        for (int d6 : mods[4][(d7 * 10 + d8) % 11]) {
          if (pandigital[d6]) {
            continue;
          }
          pandigital[d6] = true;
          int mod7 = (d6 * 10 + d7) % 7;
          for (int d5 : mods[3][mod7]) {
            if (pandigital[d5]) {
              continue;
            }
            pandigital[d5] = true;
            for (int d4 : mods[2][(d5 * 10 + d6) % 5]) {
              if (pandigital[d4]) {
                continue;
              }
              pandigital[d4] = true;
              for (int d3 : mods[1][(d4 * 10 + d5) % 3]) {
                if (pandigital[d3]) {
                  continue;
                }
                pandigital[d3] = true;
                for (int d2 : mods[0][(d3 * 10 + d4) % 2]) {
                  if (pandigital[d2]) {
                    continue;
                  }
                  pandigital[d2] = true;
                  int d1 = -1;
                  for (int i = 0; i < pandigital.length; i++) {
                    if (!pandigital[i]) {
                      d1 = i;
                      break;
                    }
                  }
                  long n = d1;
                  n = n * 10 + d2;
                  n = n * 10 + d3;
                  n = n * 10 + d4;
                  n = n * 10 + d5;
                  n = n * 10 + d6;
                  n = n * 10 + d7;
                  n = n * 10 + d8;
                  n = n * 10 + d9;
                  n = n * 10 + d10;
                  sum += n;
                  pandigital[d2] = false;
                }
                pandigital[d3] = false;
              }
              pandigital[d4] = false;
            }
            pandigital[d5] = false;
          }
          pandigital[d6] = false;
        }
        pandigital[d7] = false;
      }
    }
    return sum;
  }
}
