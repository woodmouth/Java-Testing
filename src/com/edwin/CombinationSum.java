package com.edwin;

import java.util.*;

class CombinationSum {
    private ArrayList<Integer> result;
    private final Set<List<Integer>> resultSet = new HashSet<>();
    private int target;
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>(candidates.length);
        this.target = target;
        this.candidates = candidates;
        for (int i = 0; i < candidates.length; i++) {
            System.out.println("Start point = " + candidates[i]);
            result.clear();
            process(i, 0);
        }
        List<List<Integer>> resultList = new ArrayList<>();
        for (List<Integer> element : resultSet) {
            resultList.add(element);
        }
        return resultList;
    }

    public void process(int index, int sum) {
        System.out.println("index = " + index + ", sum = " + sum);
        if (sum >= target || index == candidates.length - 1) {
            // 最后一个元素的处理
            if (sum == target) {
                // 成功匹配，输出结果
                result.add(candidates[index]);
                System.out.println("Checkpoint");
                result.forEach(e -> System.out.println(e));
                resultSet.add((List<Integer>) result.clone());
                System.out.println();
            }
            if(result.size() > 0) {
                result.remove(result.size()-1); // 返回时移除最后一个元素
            }
            return;
        }

        process(index + 1, sum); // 不选择该元素

        if (sum < target) {
            // 继续下一步骤
            result.add(candidates[index]);
            System.out.println("中间结果");
            result.forEach(e -> System.out.println(e));
            process(index + 1, sum + candidates[index]); // 选择该元素，继续下一步
        }
    }

    // Testing
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        CombinationSum solution = new CombinationSum();
        solution.combinationSum2(candidates, 8);
    }
}