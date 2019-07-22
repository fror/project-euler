/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.fror.projecteuler.math;

/**
 * @author Olivier Grégoire <fror@users.noreply.github.com>
 */
public class ToolsBenchmark {

    // @Benchmark
    public boolean timeIsPalindromic_String(int reps) {
        boolean value = false;
        for (int i = 0; i < reps; i++) {
            value ^= ToolsImplementations.isPalindromic_String(1001);
        }
        return value;
    }

    // @Benchmark
    public boolean timeIsPalindromic_StringAndCharArray(int reps) {
        boolean value = false;
        for (int i = 0; i < reps; i++) {
            value ^= ToolsImplementations.isPalindromic_StringAndCharArray(1001);
        }
        return value;
    }

    // @Benchmark
    public boolean timeIsPalindromic_fullArray_TwoMethods(int reps) {
        boolean value = false;
        for (int i = 0; i < reps; i++) {
            value ^= ToolsImplementations.isPalindromic_fullArray_TwoMethods(1001);
        }
        return value;
    }

    // @Benchmark
    public boolean timeIsPalindromic_fullArray_OneMethod(int reps) {
        boolean value = false;
        for (int i = 0; i < reps; i++) {
            value ^= ToolsImplementations.isPalindromic_fullArray_OneMethod(1001);
        }
        return value;
    }

    // @Benchmark
    public boolean timeIsPalindromic_halfArray(int reps) {
        boolean value = false;
        for (int i = 0; i < reps; i++) {
            value ^= ToolsImplementations.isPalindromic_halfArray(1001);
        }
        return value;
    }

    public static void main(String[] args) {
        // CaliperMain.main(ToolsBenchmark.class, args);
    }
}
