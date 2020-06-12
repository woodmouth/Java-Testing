import java.util.*;

//public class Solution {
//    private char[] ops = {'b', 's', 'h'};
//
//    public int maxProfit(int[] prices) {
//        // 异常输入处理
//        if (prices == null || prices.length == 0) {
//            return 0;
//        }
//
//        ArrayList<Integer> results = new ArrayList<>();
//        char[] opRecord = new char[prices.length];
//        // for(char c : opRecord) {
//        //     c = 'n';
//        //     System.out.println(c);
//        // }
//
//        process(prices, 0, results, 0, false, opRecord);
//        // 从results取出最大值
//        results.forEach(e -> System.out.println(e));
//        return (int) Collections.max(results);
//
//    }
//
//    public void process(int[] prices, int index, ArrayList<Integer> results, int profit, boolean hasBrought, char[] opRecord) {
//        System.out.println("index = " + index);
//        if (index >= prices.length - 1) {
//            results.add(profit);
//            return;
//        }
//        // 候选值为‘买’，‘卖’，‘无操作’
//        for (int i = 0; i < ops.length; i++) {
//            switch (ops[i]) {
//                case 'b':
//                    // 没有买且不在冷冻期
//                    if (index == 0 || (!hasBrought && ops[index - 1] != 's')) {
//                        opRecord[index] = 'b';
//                        process(prices, index + 1, results, profit - prices[index], true, opRecord);
//                        // 恢复节点
//                        profit = profit + prices[index];
//                        opRecord[index] = 'n';
//                    } else continue;
//                    break;
//
//                case 's':
//                    // 已经购入，可以卖出
//                    if (hasBrought) {
//                        opRecord[index] = 's';
//                        process(prices, index + 1, results, profit + prices[index], false, opRecord);
//                        // 恢复节点
//                        profit = profit - prices[index];
//                        opRecord[index] = 'n';
//                    } else continue;
//                    break;
//
//                // 不做任何操作
//                case 'h':
//                    opRecord[index] = 'h';
//                    process(prices, index + 1, results, profit, true, opRecord);
//                    opRecord[index] = 'n';
//                    break;
//            }
//        }
//    }
//}

// https://leetcode-cn.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 该题使用回溯法穷举所有的组合
        // 怪不得答案这么复杂，递归写法可以算，但是效率不高。要转化成动态规划。
        // 我去掉了print语句，过了更多测试cases，但是后边依旧超时。
        // 还能再优化一下性能，再坚持下，再剪剪枝
        // 明白了，最后的几个test cases是很丧心病狂的。。。。
        ArrayList<Integer> temp = new ArrayList<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();
        process(nums, 0, 0, temp, resultSet);

        for(List<Integer> result : resultSet) {
            resultList.add(result);
        }
        return resultList;
    }

    public void process(int[] nums, int index, int target, ArrayList<Integer> temp, Set<List<Integer>> resultSet) {
        // 结束条件
        if (index >= nums.length || temp.size() >=3) {
            // target为0，且元素是3个
            if (target == 0 && temp.size() == 3) {
                // 匹配成功，保存结果，
                // 明白了，问题再这里，这里的中间结果是不能动的，复制一份出来后再排序。
                //result.sort(Integer::compareTo);
                // 这样写是错误的，这个是浅复制
//                resultSet.add((List<Integer>) result.clone());
                ArrayList<Integer> result = new ArrayList<>(temp);
                result.sort(Integer::compareTo);
                resultSet.add(result);
                //System.out.println("result = " + temp);
            }
            return;
        }

        // 选择当前元素，继续递归，result最多三个元素
        if (temp.size() < 3) {
            temp.add(nums[index]);
            //System.out.println("nums = " + nums.toString() + ", index = " + (index+1) + ", target=" + (target - nums[index]));
            //temp.forEach(e -> System.out.print(e + " "));
            //System.out.println();
            process(nums, index + 1, target - nums[index], temp, resultSet);
            // 删除最后一个元素，恢复target，感觉是递归树回溯到上个节点的时候target的值没有恢复好。
            // 哦，对了，target不用恢复，这里的target没有被修改。注意了。
            // 我感觉就是差一点点，但是不知道错在哪里？？我感觉这道题挺简单的啊，为什么答案搞这么复杂？？估计是思路都不同，
            // 还是在研究下为什么不对，要想出一个办法可以方便递归的调试。
            temp.remove(temp.size() - 1);
            // target += nums[index];
        }

        // 不选择当前元素，继续递归
        //System.out.println("nums = " + nums.toString() + ", index = " + (index+1) + ", target=" + target);
        //temp.forEach(e -> System.out.print(e + " "));
        //System.out.println();
        process(nums, index + 1, target, temp, resultSet);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {-1, 0, 1, 2, -1, -4};
        int[] nums = {1,-1,-1,0};
        List<List<Integer>> results = solution.threeSum(nums);
        results.forEach(e -> System.out.println(e));
    }
}