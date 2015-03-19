/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import com.google.caliper.Benchmark;
import com.google.caliper.runner.CaliperMain;

/**
 *
 * @author Olivier Grégoire
 */
public class FibonacciBenchmark {

  @Benchmark
  public void timeFibonacciNaive(int reps) {
    for (int i = 0; i < reps; i++) {
      Fibonacci.fibonacciNaive(10000);
    }
  }

  @Benchmark
  public void timeFibonacciMatrix(int reps) {
    for (int i = 0; i < reps; i++) {
      Fibonacci.fibonacciMatrix(10000);
    }
  }

  @Benchmark
  public void timeFibonacciDoubling(int reps) {
    for (int i = 0; i < reps; i++) {
      Fibonacci.fibonacciDoubling(10000);
    }
  }

  public static void main(String[] args) {
    CaliperMain.main(FibonacciBenchmark.class, args);
  }
}
