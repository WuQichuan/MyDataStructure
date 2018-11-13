package set.leetcode;

import java.util.TreeSet;

/**
 * @author WuQiChuan
 * @Description: 804号问题
 * @Date: 2018/11/12 16:28
 * @Version: 1.0
 */
class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word:words) {
            StringBuilder res = new StringBuilder();
            for(int i = 0;i<word.length();i++){
                res.append(codes[word.charAt(i)-'a']);
            }
            treeSet.add(res.toString());
        }
        return treeSet.size();

    }
}
