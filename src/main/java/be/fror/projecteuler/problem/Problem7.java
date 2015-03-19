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
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is
 * 13.</p>
 * <p>
 * What is the 10 001st prime number?</p>
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem7 extends AbstractProblem {

  @Override
  public Integer solve() {
    return Primes.sieve(200000)[10000];
  }

}
