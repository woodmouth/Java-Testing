package com.edwin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListSetAndArrayTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("C", "C++", "Java");
        String[] array = list.toArray(new String[list.size()]);
        System.out.println(Arrays.toString(array));

        Set<String> set = new HashSet<>();
        set.add("Geeks");
        set.add("for");
        String[] arr = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(arr));
    }
}
