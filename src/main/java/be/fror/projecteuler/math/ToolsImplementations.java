/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

/**
 *
 * @author Olivier Grégoire <fror@users.noreply.github.com>
 */
class ToolsImplementations {
  
  static boolean isPalindromic_String(int n) {
    String s = Integer.toString(n);
    for (int start = 0, end = s.length() - 1; start < end; start++, end--) {
      if (s.charAt(start) != s.charAt(end)) {
        return false;
      }
    }
    return true;
  }
  
  static boolean isPalindromic_StringAndCharArray(int n) {
    char[] c = Integer.toString(n).toCharArray();
    for (int start = 0, end = c.length - 1; start < end; start++, end--) {
      if (c[start] != c[end]) {
        return false;
      }
    }
    return true;
  }
  
  static boolean isPalindromic_halfArray(int n) {
    int len = 1 + (int) Math.log10(n);
    int[] x = new int[len / 2];
    for (int i = 0; i < x.length; i++) {
      int q = n / 10;
      x[i] = n - q * 10;
      n = q;
    }
    if ((len & 1) != 0) {
      n /= 10;
    }
    for (int i = x.length - 1; i >= 0; i--) {
      int q = n / 10;
      if (n - q * 10 != x[i]) {
        return false;
      }
      n = q;
    }
    return true;
  }
  
  static boolean isPalindromic_fullArray_OneMethod(int n) {
    int[] x = new int[1 + (int) Math.log10(n)];
    for (int i = 0; i < x.length; i++) {
      int q = n / 10;
      x[i] = n - q * 10;
      n = q;
    }
    for (int start = 0, end = x.length - 1; start < end; start++, end--) {
      if (x[start] != x[end]) {
        return false;
      }
    }
    return true;
  }
  
  static boolean isPalindromic_fullArray_TwoMethods(int n) {
    int[] x = new int[1 + (int) Math.log10(n)];
    for (int i = 0; i < x.length; i++) {
      int q = n / 10;
      x[i] = n - q * 10;
      n = q;
    }
    return isPalindromic(x);
  }
  
  private static boolean isPalindromic(int[] x) {
    for (int start = 0, end = x.length - 1; start < end; start++, end--) {
      if (x[start] != x[end]) {
        return false;
      }
    }
    return true;
  }
  
}
