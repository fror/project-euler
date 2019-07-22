/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 * @author Olivier Grégoire
 */
public class Problem14 extends AbstractProblem {

    @Override
    public Object solve() {
        int limit = 1_000_000;
        int[] cache = new int[limit];
        cache[1] = 1;
        int maxChain = Integer.MIN_VALUE;
        int maxValue = 0;
        for (int n = 2; n < limit; n++) {
            int chain = 0;
            long t = n;
            while (t != 1L && t >= n) {
                if ((t & 1L) == 0L) {
                    t >>= 1;
                    chain++;
                } else {
                    t = (3L * t + 1L) >> 1;
                    chain += 2;
                }
            }
            cache[n] = chain + cache[(int) t];
            if (cache[n] > maxChain) {
                maxChain = cache[n];
                maxValue = n;
            }
        }
        return maxValue;
    }

}
