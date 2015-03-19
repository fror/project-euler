/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.util;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Olivier Grégoire
 */
public class Tools {

  public static List<String> readWords(String name, Splitter splitter) {
    try {
      return Lists.newArrayList(splitter.split(Resources.asCharSource(Resources.getResource(name), Charsets.UTF_8).read()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
