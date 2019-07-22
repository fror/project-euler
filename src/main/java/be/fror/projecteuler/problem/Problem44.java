/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import static java.lang.Math.sqrt;

/**
 * @author Olivier Grégoire
 */
public class Problem44 extends AbstractProblem {

    @Override
    public Object solve() {
        int i = 0;
        int D = 0;
        while (true) {
            D += 3 * i + 1;
            i++;
            for (int Pd = 0, d = 1; d < i; d++) {
                int x = 3 * d;
                Pd += x - 2;
                int j = (D - Pd) / x;
                if (D - Pd == j * x && sqrt(((3 * j - 1) * j + D) * 24 + 1) % 6 == 5) {
                    return D;
                }
            }
        }
    }

}
