import java.util.*;

class CombinationStrings {
    private Set<String> resultSet = new HashSet<>();
    private int inputLength;
    // 用于检查字符是否被占用，true为被占用，不可使用
    private boolean[] used;

    public String[] permutation(String S) {
        if (S == null || S.isEmpty()) {
            return new String[0];
        }

        inputLength = S.length();
//        char[] charArray = new char[S.length()];
//        // int i = 0;
//        for(int j = 0 ; j < S.length(); j++) {
//            charArray[j] = S.charAt(j);
//        }

        char[] charArray = S.toCharArray();
        this.used = new boolean[S.length()];
        // 多余代码，Java中boolean数组初始化所有元素都是false；
//        for(boolean e : used) {
//            e = false;
//        }

        List<Character> result = new ArrayList<>();
        process(charArray, 0, result);

        String[] output = new String[resultSet.size()];
        int i = 0;
        for (String s : resultSet) {
            output[i] = s;
        }
        return output;
    }

    private void process(char[] candidates, int start, List<Character> result) {
        // 结束条件是result长度等于S的长度
        if (result.size() == inputLength) {
            // 输出结果，然后返回
            StringBuilder sb = new StringBuilder(result.size());
            for (char c : result) {
                System.out.println("element = " + c);
                sb.append(c);
            }
            resultSet.add(sb.toString());
            System.out.println("final result = " + sb.toString());
            return;

        } else {
            // 递归调用，发现这个场景下应该是每次从0开始，还要检测这个字符是否被占用
            // 到底这里从start开始还是从0开始，是一个必须解决的问题
//            for (int i = start; i < charArray.length; i++) {
            for (int i = 0; i < candidates.length; i++) {
                // 如果字符被占用，要跳到下个字符
                if(used[i]) continue;

                System.out.println("i = " + i + ", char = " + candidates[i]);
                result.add(candidates[i]);
                used[i] = true;
                displayResult(result);
                process(candidates, i + 1, result);
                result.remove(result.size() - 1);
                used[i] = false;
                displayResult(result);
            }
        }
    }

    // 检测字符是否已经被使用
//    public static boolean isOK() {
//        // 这里有没有什么好方法可以快速检查该字符是否已经被使用？？
//    }

//    public static void main(String[] args) {
//        CombinationStrings solution = new CombinationStrings();
//        solution.permutation("abc");
//    }

    public static void displayResult(List<Character> result) {
        StringBuilder sb = new StringBuilder(result.size());
        for (char c : result) {
            sb.append(c);
        }
        System.out.println("Display result = " + sb.toString());
    }
}