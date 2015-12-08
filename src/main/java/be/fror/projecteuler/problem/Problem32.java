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
public class Problem32 extends AbstractProblem {

  @Override
  public Object solve() {
    final int PANDIGITAL = 1022; // 1022 represents 1-9 pandigital, bitwise.
    final int N = 9876;
    final int MAX_PROPER_DIVISORS = 63; // maximum number of proper divisors for n <= N. Computed to optimize memory & speed. 

    final int[][] div = new int[N + 1][MAX_PROPER_DIVISORS];

    int sum = 0;
    for (int n = 2; n <= N; n++) {
      int bits = 0;
      { // transform n into its digitset as bits.
        int x = n;
        do {
          final int tmp = x / 10;
          bits |= 1 << (x - tmp * 10);
          x = tmp;
        } while (x > 0);
      }

      // Add n (as bits) as divisor of all of its multiples:
      //   . except n
      //   . skip each multiple < 1234
      // div[x][0] always contains the number of divisors so far (bar 1)
      for (int m = (n >= 617 ? n << 1 : ((1233 / n) + 1) * n); m <= N; m += n) {
        div[m][++div[m][0]] = bits;
      }

      // Basic analysis says that any n will be higher than 1234.
      // Skip if n contains a 0, it's more than 1/4 of cases!
      if (n >= 1234 && (bits & 1) == 0) {
        // Speed comparison seems to show that this is more efficient
        // than using div[n] everywhere.
        final int[] d = div[n];
        for (int start = 1, end = d[0]; start < end; start++, end--) {
          // Analysis says that bitwise-or is sufficient.
          // Another possibility is using xor.
          if ((bits | d[start] | d[end]) == PANDIGITAL) {
            sum += n;
            break; // don't count duplicates
          }
        }
      }
    }
    return sum;
  }
}
