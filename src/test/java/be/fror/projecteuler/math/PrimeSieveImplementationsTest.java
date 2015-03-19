/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Olivier Grégoire <https://github.com/fror>
 */
public class PrimeSieveImplementationsTest {
  @Test
  public void testSieveOfAtkin_optimized() {
    for (int i = 10; i <= 100_000_000; i *= 10) {
      // Assert.assertArrayEquals(""+i, PrimesSieveImplementations.sieveOfEratosthenes(i), PrimesSieveImplementations.sieveOfAtkin_optimized(i));
    }
  }
}
