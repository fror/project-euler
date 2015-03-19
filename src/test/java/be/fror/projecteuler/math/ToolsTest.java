/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Olivier Grégoire
 */
public class ToolsTest {

  @Test
  public void testIsPalindromic() {
    for (int i = 1; i < 100; i++) {
      Assert.assertThat(Tools.isPalindromic(i), CoreMatchers.is((i < 10 || i % 11 == 0)));
    }
    for (int i = 101; i < 1000; i++) {
      Assert.assertThat(Tools.isPalindromic(i), CoreMatchers.is(i / 100 == i % 10));
    }
  }
}
