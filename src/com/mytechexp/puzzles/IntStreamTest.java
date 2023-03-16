package com.mytechexp.puzzles;

import java.util.stream.IntStream;

public class IntStreamTest {
    public static void main(String[] args) {
        var sum = IntStream.rangeClosed(1, 10)
                .sum();
        System.out.println(sum);
//Limiting to some range
        IntStream.rangeClosed(1,10)
                .skip(1)
                .limit(5)
                .forEach(System.out::println);
    }
}
