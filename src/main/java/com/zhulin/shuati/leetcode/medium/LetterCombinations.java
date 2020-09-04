package com.zhulin.shuati.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 通过次数141,708  提交次数261,404
 **/
public class LetterCombinations {


    static Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    /**
     * 方法：回溯
     * 回溯是一种通过穷举所有可能情况来找到所有解的算法。如果一个候选解最后被发现并不是可行解，回溯算法会舍弃它，并在前面的一些步骤做出一些修改，并重新尝试找到可行解。
     * <p>
     * 给出如下回溯函数 backtrack(combination, next_digits) ，它将一个目前已经产生的组合 combination 和接下来准备要输入的数字 next_digits 作为参数。
     * <p>
     * 如果没有更多的数字需要被输入，那意味着当前的组合已经产生好了。
     * 如果还有数字需要被输入：
     * 遍历下一个数字所对应的所有映射的字母。
     * 将当前的字母添加到组合最后，也就是 combination = combination + letter 。
     * 重复这个过程，输入剩下的数字： backtrack(combination + letter, next_digits[1:]) 。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static void backtrack(String combination, String next_digits, List<String> output) {
        // 终止条件，当需要被插入的数字为0时说明满足要求了，直接退出
        if (next_digits.length() == 0) {
            // 将结果放入结果集
            output.add(combination);
            return;
        }
        // 拿出当前层需要处理的数字
        String digit = next_digits.substring(0, 1);
        // 拿出数字对应的字母组合
        String letters = phone.get(digit);
        // 用当前结果 + 循环拼接
        for (int i = 0; i < letters.length(); i++) {
            // 将当前结果拼接后传入下一层，并截取掉已经处理过的数字
            backtrack(combination + phone.get(digit).charAt(i), next_digits.substring(1),output);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if (digits.length() != 0)
            backtrack("", digits,output);
        return output;
    }

    /**
     * 队列实现
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        //一个映射表，第二个位置是"abc“,第三个位置是"def"。。。
        //这里也可以用map，用数组可以更节省点内存
        String[] letter_map = {
                " ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> res = new ArrayList<>();
        //先往队列中加入一个空字符
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            //由当前遍历到的字符，取字典表中查找对应的字符串
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            //计算出队列长度后，将队列中的每个元素挨个拿出来
            for (int j = 0; j < size; j++) {
                //每次都从队列中拿出第一个元素
                String tmp = res.remove(0);
                //然后跟"def"这样的字符串拼接，并再次放到队列中
                for (int k = 0; k < letters.length(); k++) {
                    res.add(tmp + letters.charAt(k));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println('2' - '0');
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations(""));
    }
}
