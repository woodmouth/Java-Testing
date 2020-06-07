package com.edwin;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 以下例子是获取浮点数的整数部分和小数部分
        float a;
        System.out.print("请输入一个浮点数：");
        a=scanner.nextFloat();
        System.out.println("整数部分是：" + (int)a);
        System.out.print("小数部分是：" + a%1);

        while (scanner.hasNext()) {
            int counter = scanner.nextInt();
            Set<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < counter; i++) {
                int number = scanner.nextInt();
                treeSet.add(number);
            }

            for (Integer i : treeSet) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}