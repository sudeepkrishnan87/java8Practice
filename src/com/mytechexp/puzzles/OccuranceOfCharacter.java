package com.mytechexp.puzzles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccuranceOfCharacter {
    public static void main(String []arg)
    {
        String input="Testyourskilsets";
        /*String[] output = input.split("");
        System.out.println(Arrays.toString(output));*/
        Map<String, Long> map = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);

    }
}
