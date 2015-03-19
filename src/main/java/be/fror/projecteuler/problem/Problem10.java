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

import be.fror.projecteuler.math.Primes;

/**
 * <p>
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.</p>
 * <p>
 * Find the sum of all the primes below two million.</p>
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem10 extends AbstractProblem {

  @Override
  public Object solve() {
    long sum = 0L;
    for (long prime : Primes.sieve(2000000)) {
      sum += prime;
    }
    return sum;
  }

}
