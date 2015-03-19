/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem40 extends AbstractProblem {

  @Override
  public Object solve() {
    int product = 1;
    outer:
    for (int index = 1; index <= 1000000; index *= 10) {
      int realIndex = index - 1;
      int firstindex = 0;
      int numcount = 9;
      int firstnum = 1;
      for (int numlen = 1; numlen < 10; numlen++) {
        int groupindex = (realIndex - firstindex) / numlen;
        if (groupindex < numcount) {
          int n = firstnum + groupindex;
          int digitIndex = (realIndex - firstindex) % numlen;
          product *= Integer.toString(n, 10).charAt(digitIndex) - '0';
          continue outer;
        }
        firstindex += numlen * numcount;
        firstnum *= 10;
        numcount *= 10;
      }
    }
    return product;
  }
}
