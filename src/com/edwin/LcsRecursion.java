package com.edwin;

// 使用递归实现最长公共子序列问题，the recusive LCS algorithm
// 使用递归算法的问题是，只能求最长公共子串的长度，并不能给出子串的值。
// 参考网页：http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/DynProg/Progs/LCS/LCS0.java
public class LcsRecursion {

    // 以下process是我自己写的，有点问题。
//    public static int process(char[] x, char[] y, int i, int j) {
//        // 终止条件
//        if(i == 0 || j == 0) {
//            return 0;
//        }
//
//        if (x[i] == y[j]) {
//            return process(x, y, i-1, j-1) + 1;
//        } else {
//            return Math.max(process(x, y, i, j-1), process(x, y, i-1, j));
//        }
//    }

    // 正确答案
    public static int process(char[] x, char[] y, int i, int j) {
        // 终止条件
        if(i == 0 || j == 0) {
            return 0;
        }

        // 注意这里是用-1，这样参数i, j可以传字符串的长度
        if(x[i-1] == y[j-1]) {
            return process(x, y, i-1, j-1) + 1;
        } else {
            return Math.max(process(x, y, i-1, j), process(x, y, i, j-1));
        }
    }


    // 终于对了，都是因为差一问题导致结果不对。
    public static void main(String[] args) {
        String x = "abcd";
        String y = "acdb";
        int maxLength = process(x.toCharArray(), y.toCharArray(), x.length(), y.length());
        System.out.println("maxLength = " + maxLength);
    }
}
