package com.roytuts.java.parallel.stream.api;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamSideEffectsApp {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Michel");

        try {
            String addAnotherName = names.stream().peek(s -> names.add("Adrish")).reduce((s1, s2) -> s1 + " " + s2)
                    .get();

            System.out.println("Additional Name: " + addAnotherName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

}
