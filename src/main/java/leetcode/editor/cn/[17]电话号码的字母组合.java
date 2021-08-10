package leetcode.editor.cn;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1438 👎 0

import java.util.ArrayList;
import java.util.List;

//Java：电话号码的字母组合
class LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] data = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        conversion(list, digits, 0, new StringBuilder());
        return list;
    }

    private void conversion(List<String> list, String digits, int index, StringBuilder builder) {
        if (builder.length() == digits.length())
            list.add(builder.toString());
        else {
            int k = digits.charAt(index) - '0';
            String s = data[k - 2];
            for (int i = 0; i < s.length(); i++) {
                builder.append(s.charAt(i));
                conversion(list, digits, index + 1, builder);
                builder.deleteCharAt(index);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
