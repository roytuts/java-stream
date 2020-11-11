package com.roytuts.java.parallel.stream.api;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class ParallelStreamReductionApp {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(new Employee("John", "Developer"),
                new Employee("Michel", "Sr Developer"), new Employee("Harris", "Developer"),
                new Employee("Kamla", "Sr Developer"), new Employee("Jerome", "Manager"));

        Map<String, List<Employee>> byDesignationConcurrent = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDesignation));

        byDesignationConcurrent.forEach((k, v) -> System.out.println(k + " => " + v));

        System.out.println();
        System.out.println("========================================================");
        System.out.println();

        ConcurrentMap<String, List<Employee>> byDesignationConcurrentMap = employees.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getDesignation));

        byDesignationConcurrentMap.forEach((k, v) -> System.out.println(k + " => " + v));

    }

}
