package com.edwin;

// 使用递归实现最长公共子序列问题
public class LcsRecursion {

    public static int process(char[] x, char[] y, int i, int j) {
        // 终止条件
        if(i == 0 || j == 0) {
            return 0;
        }

        if (x[i] == y[j]) {
            return process(x, y, i-1, j-1) + 1;
        } else {
            return Math.max(process(x, y, i, j-1), process(x, y, i-1, j));
        }
    }

    public static void main(String[] args) {
        char[] x = {'a', 'b', 'c', 'd'};
        char[] y = {'a', 'e', 'd', 'b'};
        int maxLength = process(x, y, x.length - 1, y.length -1);
        System.out.println("maxLength = " + maxLength);
    }
}
