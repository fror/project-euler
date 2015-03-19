/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.math.Primes;
import com.google.common.collect.Collections2;

import java.util.Arrays;
import java.util.List;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n
 * exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * <p>
 * What is the largest n-digit pandigital prime that exists?
 *
 */
public class Problem41 extends AbstractProblem {

  @Override
  public Object solve() {
    List<Integer> ints = Arrays.asList(7, 6, 5, 4, 3, 2, 1); // No prime 8- or 9-pandigital number exists: they're all divisible by 3.
    int max = Integer.MIN_VALUE;
    for (int count = 0; count <= ints.size(); count++) {
      for (List<Integer> perm : Collections2.permutations(ints.subList(count, ints.size()))) { // lexicographic order.
        int n = 0;
        for (int i : perm) {
          n = n * 10 + i;
        }
        if (Primes.isPrime(n) && n > max) {
          max = n;
        }
      }
      if (max != Integer.MIN_VALUE) {
        return max;
      }
    }
    return null;
  }
}
