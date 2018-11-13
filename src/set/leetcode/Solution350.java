package set.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author WuQiChuan
 * @Description:
 * @Date: 2018/11/13 14:05
 * @Version: 1.0
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i:nums1) {
            if(!treeMap.containsKey(i)){
                treeMap.put(i,1);
            }else{
                treeMap.put(i,treeMap.get(i) + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int num:nums2) {
            if(treeMap.containsKey(num)){
                list.add(num);
                treeMap.put(num,treeMap.get(num) - 1);
                if(treeMap.get(num) == 0){
                    treeMap.remove(num);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;

    }
}
