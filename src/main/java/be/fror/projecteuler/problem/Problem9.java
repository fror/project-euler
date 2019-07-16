/*
 * Copyright 2015 Olivier Grégoire <fror@users.noreply.github.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package be.fror.projecteuler.problem;

/**
 * <p>
 * A Pythagorean triplet is a set of three natural numbers, <var>a</var> &lt; <var>b</var> &lt;
 * <var>c</var>, for which,</p>
 * <div style="text-align:center;"> <var>a</var><sup>2</sup> + <var>b</var><sup>2</sup> =
 * <var>c</var><sup>2</sup></div>
 * <p>
 * For example, 3<sup>2</sup> + 4<sup>2</sup> = 9 + 16 = 25 = 5<sup>2</sup>.</p>
 * <p>
 * There exists exactly one Pythagorean triplet for which <var>a</var> + <var>b</var> + <var>c</var>
 * = 1000.<br />Find the product <var>abc</var>.</p>
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem9 extends AbstractProblem {

  @Override
  public Object solve() {
    return primitive(1000);
  }

  private int fastNaive(final int targetSum) {
    double sqrt2 = Math.sqrt(2);
    for (int c = (int) (targetSum * sqrt2 / (2 + sqrt2)), C = targetSum / 2 + 1; c < C; c++) {
      for (int a = Math.max(1, targetSum - c - c +   1),
          A = Math.min(targetSum / 3, (targetSum - c) / 2);
          a < A;
          a++) {
        int b = targetSum - c - a;
        if (a * a + b * b == c * c) {
          return a * b * c;
        }
      }
    }
    throw new AssertionError();
  }

  private int primitive(int targetSum) {
    int a, b, c;
    int x = 3;
    do {
      a = x++;
      if ((a & 1) != 0) {
        b = a * a / 2;
        c = b + 1;
      } else {
        b = a * a / 4 - 1;
        c = b + 2;
      }
    } while (targetSum % (a + b + c) != 0);
    int k = targetSum / (a + b + c);
    return a * b * c * k * k * k;
  }
}
