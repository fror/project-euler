/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.common.base.Stopwatch;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import com.google.inject.Inject;
import com.google.inject.Provider;

import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Olivier Grégoire
 */
public class ProblemRunner {

  private final TimeLimiter timeLimiter;
  private final Provider<Stopwatch> stopwatchProvider;
  private final PrintStream output;

  @Inject
  public ProblemRunner(TimeLimiter timeLimiter, Provider<Stopwatch> stopwatchProvider,
      PrintStream output) {
    this.timeLimiter = timeLimiter;
    this.stopwatchProvider = stopwatchProvider;
    this.output = output;
  }

  public void run(Problem problem) {
    output.printf("%nRunning problem %d...%n", problem.getId());
    Stopwatch stopwatch = stopwatchProvider.get();

    Problem timeLimitedProblem = timeLimiter.newProxy(problem, Problem.class, 1, TimeUnit.MINUTES);
    try {
      Object result;
      stopwatch.start();
      result = timeLimitedProblem.solve();
      stopwatch.stop();

      output.printf("\tResult: %s%n", result);
      output.printf("\tTook %s to solve.%n", stopwatch);
    } catch (UncheckedTimeoutException e) {
      output.printf("\tFailed to get a result under one minute.%n");
    } catch (Exception e) {
      throw Throwables.propagate(e);
    } finally {
      output.printf("%n");
    }
  }
}
