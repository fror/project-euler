/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import com.google.caliper.Benchmark;
import com.google.caliper.Param;
import com.google.caliper.runner.CaliperMain;

/**
 *
 * @author Olivier Grégoire <https://github.com/fror>
 */
public class PrimesSieveBenchmark {

  private final int MAX_TO_SIEVE = 500_000;

  @Param({"100000", "1000000", "10000000"})
  int toSieve;

  @Benchmark
  public int timeSieveOfEratosthenes(int reps) {
    int n = 0;
    for (int i = 0; i < reps; i++) {
      n ^= n << 1 - PrimesSieveImplementations.sieveOfEratosthenes(toSieve).length;
    }
    return n;
  }

  @Benchmark
  public int timeSieveOfAtkin(int reps) {
    int n = 0;
    for (int i = 0; i < reps; i++) {
      n ^= n << 1 - PrimesSieveImplementations.sieveOfAtkin(toSieve).length;
    }
    return n;
  }

  @Benchmark
  public int timeSieveOfAtkin_optimized(int reps) {
    int n = 0;
    for (int i = 0; i < reps; i++) {
      n ^= n << 1 - PrimesSieveImplementations.sieveOfAtkin_optimized(toSieve).length;
    }
    return n;
  }

  public static void main(String[] args) {
    CaliperMain.main(PrimesSieveBenchmark.class, args);
  }

}
