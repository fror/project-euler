/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.common.base.Throwables;

/**
 *
 * @author Olivier Grégoire
 */
public class ProblemFactory {

  private static final String PROBLEMS_PACKAGE = "be.fror.projecteuler.problem";

  /**
   * Gets the problem with the given ID.
   *
   * @param id the ID (problem number) of the problem.
   * @return a problem.
   */
  public Problem getProblem(int id) {
    try {
      Class<?> problemClass = Class.forName(PROBLEMS_PACKAGE + ".Problem" + id);
      return (Problem) problemClass.newInstance();
    } catch (ClassNotFoundException e) {
      throw new ProblemNotFoundException("Problem " + id + " not found.");
    } catch (Exception e) {
      throw Throwables.propagate(e);
    }
  }

  /**
   * Exception thrown when a problem cannot be found for a given ID.
   */
  public static class ProblemNotFoundException extends RuntimeException {

    public ProblemNotFoundException(String message) {
      super(message);
    }
  }
}
