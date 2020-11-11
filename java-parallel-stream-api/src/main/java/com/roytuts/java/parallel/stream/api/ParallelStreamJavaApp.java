package com.roytuts.java.parallel.stream.api;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamJavaApp {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);

        double avg = integers.parallelStream().mapToInt(i -> i).average().getAsDouble();
        System.out.println("Average: " + avg);
    }

}
