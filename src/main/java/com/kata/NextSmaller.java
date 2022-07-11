package com.kata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class NextSmaller {

    public static long nextSmaller(long n) {
        String numberStr = String.valueOf(n);
        List<String> numberLists = Arrays.asList(numberStr.split(""));
        return permutationNoRepeat(numberLists, numberStr.length(), numberStr);
    }

    public static Integer permutationNoRepeat(List<String> numberLists, int numberLength, String myNumber) {
        Stream<String> stream = numberLists.stream();
        /*把排列組合都做好*/
        for (int n = 1; n < numberLength; n++) {
            stream.flatMap(str -> numberLists.stream()
                    .filter(temp -> !str.contains(temp))
                    .map(str::concat)).forEach(aa -> System.out.println("aa = " + aa));
        }
        /*取出比我帶進來的數字還要小的"所有數字"然後取最大值*/
        Optional<String> max = stream.
                filter(number -> Integer.parseInt(number) < Integer.parseInt(myNumber))
                .max(Comparator.comparing(String::valueOf));
        /*找不到最大值了就是回傳-1*/
        return max.map(Integer::parseInt).orElse(-1);
    }
}
