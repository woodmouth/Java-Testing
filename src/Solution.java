import java.util.*;

public class Solution {
    private char[] ops = {'b', 's', 'h'};

    public int maxProfit(int[] prices) {
        // 异常输入处理
        if (prices == null || prices.length == 0) {
            return 0;
        }

        ArrayList<Integer> results = new ArrayList<>();
        char[] opRecord = new char[prices.length];
        // for(char c : opRecord) {
        //     c = 'n';
        //     System.out.println(c);
        // }

        process(prices, 0, results, 0, false, opRecord);
        // 从results取出最大值
        results.forEach(e -> System.out.println(e));
        return (int) Collections.max(results);

    }

    public void process(int[] prices, int index, ArrayList<Integer> results, int profit, boolean hasBrought, char[] opRecord) {
        System.out.println("index = " + index);
        if (index >= prices.length - 1) {
            results.add(profit);
            return;
        }
        // 候选值为‘买’，‘卖’，‘无操作’
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case 'b':
                    // 没有买且不在冷冻期
                    if (index == 0 || (!hasBrought && ops[index - 1] != 's')) {
                        opRecord[index] = 'b';
                        process(prices, index + 1, results, profit - prices[index], true, opRecord);
                        // 恢复节点
                        profit = profit + prices[index];
                        opRecord[index] = 'n';
                    } else continue;
                    break;

                case 's':
                    // 已经购入，可以卖出
                    if (hasBrought) {
                        opRecord[index] = 's';
                        process(prices, index + 1, results, profit + prices[index], false, opRecord);
                        // 恢复节点
                        profit = profit - prices[index];
                        opRecord[index] = 'n';
                    } else continue;
                    break;

                // 不做任何操作
                case 'h':
                    opRecord[index] = 'h';
                    process(prices, index + 1, results, profit, true, opRecord);
                    opRecord[index] = 'n';
                    break;
            }
        }
    }
}