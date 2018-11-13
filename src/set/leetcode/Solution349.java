package set.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: 2018/11/13 14:05
 * @Version: 1.0
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i:nums1) {
            treeSet.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums2) {
            if(treeSet.contains(num)){
                list.add(num);
                treeSet.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
