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
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.</p>
 * <p>
 * Find the sum of all the multiples of 3 or 5 below 1000.</p>
 *
 * @author Olivier Grégoire &lt;fror@users.noreply.github.com&gt;
 */
public class Problem1 extends AbstractProblem {

    @Override
    public Object solve() {
        int MAX = 999;
        return sumOfMultiples(3, MAX) + sumOfMultiples(5, MAX) - sumOfMultiples(3 * 5, MAX);
    }

    private int sumOfMultiples(int n, int max) {
        int nMax = max / n;
        return nMax * (nMax + 1) / 2 * n;
    }

}
