/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.inject.Inject;

import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Olivier Grégoire
 */
public class Application {

  private final PrintStream output;
  private final Scanner scanner;
  private final ProblemFactory problemFactory;
  private final ProblemRunner problemRunner;

  @Inject
  public Application(PrintStream output, Scanner scanner,
      ProblemFactory problemFactory,
      ProblemRunner problemRunner) {
    this.output = output;
    this.scanner = scanner;
    this.problemFactory = problemFactory;
    this.problemRunner = problemRunner;
  }

  public void start() {
    output.print("Enter problem number: ");
    int problemNumber = scanner.nextInt();

    Problem problem = problemFactory.getProblem(problemNumber);
    problemRunner.run(problem);
  }
}
