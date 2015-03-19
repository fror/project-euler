/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.inject.AbstractModule;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Olivier Grégoire
 */
public class IOModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(PrintStream.class).toInstance(System.out);
    bind(Scanner.class).toInstance(new Scanner(System.in));
  }
}
