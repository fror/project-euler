/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.inject.Guice;

/**
 *
 * @author Olivier Grégoire
 */
public class ProjectEuler {

  public static void main(String[] args) {
    Guice.createInjector(new IOModule(), new TimeModule(), new ApplicationModule())
        .getInstance(Application.class)
        .start();
  }

}
