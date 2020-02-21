package xin.zhuyao.test.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zy
 * Date: 2019/5/28
 * Time: 12:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String x = l1.val+"";
        while (l1.next != null) {
            l1 = l1.next;
            x = x + l1.val;
        }
        String y = l2.val+"";
        while (l2.next != null) {
            l2 = l2.next;
            y = y + l2.val;
        }
        String[] splitX = x.split("");
        String[] splitY = y.split("");
        List<Integer> list = new ArrayList<>();
        int z = 0;
        for (int i = 0; i < splitX.length || i < splitY.length; i++) {
            int x1 = 0;
            int y1 = 0;
            if (splitX.length > i) {
                x1 = Integer.valueOf(splitX[i]);
            }
            if (splitY.length > i) {
                y1 = Integer.valueOf(splitY[i]);
            }
            list.add((x1 + y1 + z) % 10);
            z = (x1 + y1 + z) / 10;
        }
        if (z != 0)
            list.add(z);
        List<ListNode> listNodeList = new ArrayList<>();
        for (Integer integer : list) {
            listNodeList.add(new ListNode(integer));
        }
        for (int i = 1; i < listNodeList.size(); i++) {
            listNodeList.get(i - 1).next = listNodeList.get(i);
        }
        return listNodeList.get(0);
    }

    public static void main(String[] args) {

        /**
         * [2,4,3]
         * [5,6,4]
         */
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);

        addTwoNumbers(l1,l2);
    }

}
