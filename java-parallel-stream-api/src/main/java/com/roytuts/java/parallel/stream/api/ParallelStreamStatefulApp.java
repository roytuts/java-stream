package com.roytuts.java.parallel.stream.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParallelStreamStatefulApp {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        /*
         * List<Integer> integers = new ArrayList<>(); integers.add(1); integers.add(2);
         * integers.add(3); integers.add(4); integers.add(5); integers.add(6);
         * integers.add(7); integers.add(8); integers.add(9); integers.add(10);
         * integers.add(11);
         */

        List<Integer> storage = new ArrayList<>();

        System.out.println("Serial stream:");

        integers.stream().map(i -> {
            storage.add(i);
            return i;
        }).forEach(i -> System.out.print(i + " "));// .forEachOrdered(i -> System.out.print(i + " "));

        System.out.println();

        // storage.stream().forEachOrdered(i -> System.out.print(i + " "));
        storage.stream().forEach(i -> System.out.print(i + " "));

        System.out.println();

        System.out.println("=================================");
        
        System.out.println("Parallel Stream:");
        
        List<Integer> parallelStorage = Collections.synchronizedList(new ArrayList<>());

        integers.parallelStream().map(i -> {
            parallelStorage.add(i);
            return i;
        }).forEach(i -> System.out.print(i + " "));//.forEachOrdered(i -> System.out.print(i + " "));

        System.out.println();

        //parallelStorage.stream().forEachOrdered(i -> System.out.print(i + " "));
        parallelStorage.stream().forEach(i -> System.out.print(i + " "));

        System.out.println();
    }

}
