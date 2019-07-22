/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import java.util.concurrent.ExecutorService;
import static java.util.concurrent.Executors.newFixedThreadPool;
import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Olivier Grégoire
 */
public class ApplicationModule extends AbstractModule {

  @Provides
  @Singleton
  TimeLimiter provideTimeLimiter() {
    ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setDaemon(true)
            .setNameFormat("problem-thread-%d")
            .build();
    ExecutorService executor = newFixedThreadPool(4, threadFactory);
    return SimpleTimeLimiter.create(executor);
  }

}
