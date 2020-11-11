package com.roytuts.java.parallel.stream.api;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamOrderingApp {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        // System.out.println("Sequential Stream");
        // System.out.println();
        // integers.stream().forEach(i -> System.out.print(i + " "));

        // System.out.println();
        // System.out.println("===========================");
        // System.out.println();

        // System.out.println("Parallel Stream");
        // System.out.println();
        // integers.parallelStream().forEach(i -> System.out.print(i + " "));
        
        //System.out.println();
         System.out.println("===========================");
         System.out.println();

         System.out.println("Parallel Stream with Order");
         System.out.println();
         integers.parallelStream().forEachOrdered(i -> System.out.print(i + " "));
    }

}
