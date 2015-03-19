/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import be.fror.projecteuler.util.Tools;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem22 extends AbstractProblem {

  private static final List<String> names = Tools.readWords("names.txt", Splitter.on(',').trimResults(CharMatcher.is('"')));

  @Override
  public Object solve() {
    Collections.sort(names);
    int sum = 0;
    for (int i = 0, l = names.size(); i < l; i++) {
      String name = names.get(i);
      int value = -name.length() * ('A' - 1);
      for (int j = 0; j < name.length(); j++) {
        value += name.charAt(j);
      }
      sum += (i + 1) * value;
    }
    return sum;
  }

}
