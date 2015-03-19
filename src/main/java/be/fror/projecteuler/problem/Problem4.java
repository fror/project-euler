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

import be.fror.projecteuler.math.Tools;

/**
 * <p>
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 &times; 99.</p>
 * <p>
 * Find the largest palindrome made from the product of two 3-digit numbers.</p>
 *
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem4 extends AbstractProblem {

  @Override
  public Object solve() {
    int greatestPalindromic = Integer.MIN_VALUE;
    int stop = Integer.MIN_VALUE;
    for (int i = 999, sqi = i * i; stop < i; i--, sqi -= (i + i - 1)) {
      for (int product = i * 999; sqi <= product && greatestPalindromic < product; product -= i) {
        if (Tools.isPalindromic(product)) {
          greatestPalindromic = product;
          stop = product / 999;
          break;
        }
      }
    }
    return greatestPalindromic;
  }

}
