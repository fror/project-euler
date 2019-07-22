/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.common.base.Stopwatch;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 *
 * @author Olivier Grégoire
 */
public class TimeModule extends AbstractModule {

  @Provides
  Stopwatch provideStopwatch() {
    return Stopwatch.createUnstarted();
  }

}
