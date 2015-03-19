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
 * The prime factors of 13195 are 5, 7, 13 and 29.</p>
 * <p>
 * What is the largest prime factor of the number 600851475143 ?</p>
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem3 extends AbstractProblem {

  @Override
  public Long solve() {
    long[] factors = Primes.factorize(600851475143L);
    return factors[factors.length - 1];
  }

}
