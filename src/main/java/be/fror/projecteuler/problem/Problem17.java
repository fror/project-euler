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
public class Problem17 extends AbstractProblem {

  @Override
  public Object solve() {
    int onetonine = "onetwothreefourfivesixseveneightnine".length();
    int tentonineteen = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
    int and = "and".length();
    int twentytoninety = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
    int hundred = "hundred".length();
    int thousand = "thousand".length();
    return "one".length() + thousand
        + 900 * hundred + 100 * onetonine
        + 100 * twentytoninety + 891 * and
        + 80 * onetonine + 10 * (onetonine + tentonineteen);
  }

}
