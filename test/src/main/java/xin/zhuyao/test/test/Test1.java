package xin.zhuyao.test.test;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/28
 * Time: 17:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test1 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null||s.equals("")) {
            return 0;
        }
        String[] split = s.split("");
        List<String> list = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            if (list.contains(split[i])) {
                i = i + 1 - list.size();
                list.clear();
            }
            list.add(split[i]);
            if (max < list.size()) {
                max = list.size();
            }
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] x = new int[nums1.length + nums2.length];
        for (int i : nums1) {
            x[i] = nums1[i];
        }
        for (int i : nums2) {
            x[nums1.length + i] = nums2[i];
        }
        return 1.0;
    }

    public static void main(String[] args) {
        String x = "";
        int i = lengthOfLongestSubstring(x);
        System.out.println(i);
    }



}
