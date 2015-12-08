/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.problem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Olivier Grégoire
 */
public class Problem19 extends AbstractProblem {

  @Override
  public Object solve() {
    final LocalDate start = LocalDate.of(1901, Month.JANUARY, 1);
    final LocalDate end = LocalDate.of(2000, Month.DECEMBER, 31);

    int count = 0;
    for (LocalDate date = start; date.isBefore(end); date = date.plusMonths(1)) {
      if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
        count++;
      }
    }
    return count;
  }

}
