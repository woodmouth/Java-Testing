package com.edwin;

public class ArrayTest {
    public static void updateArray(int[] array) {
        array[0] = 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        updateArray(array);
        System.out.printf("%d\n", array[0]);

        boolean[] boolArray = new boolean[10];
        for(boolean e : boolArray) {
            System.out.println(e);
        }
    }
}
