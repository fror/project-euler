/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Olivier Grégoire
 */
public class FibonacciTest {

    static final int[] numbers = new int[50];

    @BeforeClass
    public static void setUpClass() {
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1 << 20);
        }
    }

    @Test
    public void testFibonacciDoubling() {

        long sum = 0L;
        for (int n : numbers) {
            long start, end;
            start = System.nanoTime();
            Fibonacci.fibonacciDoubling(n);
            end = System.nanoTime();
            sum += end - start;
        }

        Stopwatch sw = Stopwatch.createStarted(new FixedTicker(sum / numbers.length)).stop();
        System.out.println("testFibonacciDoubling: " + sw);
    }

    @Test
    public void testFibonacciMatrix() {

        long sum = 0L;
        for (int n : numbers) {
            long start, end;
            start = System.nanoTime();
            Fibonacci.fibonacciMatrix(n);
            end = System.nanoTime();
            sum += end - start;
        }

        Stopwatch sw = Stopwatch.createStarted(new FixedTicker(sum / numbers.length)).stop();
        System.out.println("testFibonacciMatrix: " + sw);
    }

    static final class FixedTicker extends Ticker {

        private final long value;
        private boolean first = true;
        int call = 0;

        FixedTicker(long value) {
            this.value = value;
        }

        @Override
        public long read() {
            if (first) {
                first = false;
                return 0;
            } else {
                return value;
            }
        }

    }
}
