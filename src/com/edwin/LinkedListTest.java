package com.edwin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


/**
 * This program demostrates operations on linked list
 * @version 1.0 2020-04-28
 * @author Edwin Lin
 */
public class LinkedListTest {

    public static void main(String[] args) {
	// write your code here
        List<String> a = new LinkedList<>();
        a.add("Amy");
        System.out.println("Testing");

        char[] chars = {'H', 'e', 'l', 'l', 'o', 'w','o', 'r', 'l', 'd'};
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        System.out.println(sb.toString());

        StringBuilder sb1 = new StringBuilder("HelloWorld");
        char[] dest = sb1.toString().toCharArray();
        System.out.println(dest[0]);

        float number = 100.0F;
        String numberStr = String.valueOf(number);
        System.out.println(numberStr);

        String intNumber = "100";
        String floatNumber = "100.11";
        int number1 = Integer.parseInt(intNumber);
        long number2 = Long.parseLong(intNumber);
        float number3 = Float.parseFloat(floatNumber);
        double number4 = Double.parseDouble(floatNumber);
        System.out.println(number1);
        System.out.println(number2);
        System.out.println(number3);
        System.out.println(number4);

        String intStr = "100";
        String floatStr = "100.11";
        BigInteger bigInteger = new BigInteger(intStr);
        BigDecimal bigDecimal = new BigDecimal(floatStr);
        System.out.println("Checkout point");
        System.out.println(bigInteger.toString());
        System.out.println(bigDecimal.toString());
    }
}
