package com.blankj.easy._021;

import com.blankj.structure.ListNode;
import com.blankj.structure.ListNodeMe;

import static java.lang.System.out;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/29
 *     desc  :
 * </pre>
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static void main2(String[] args) {
        Solution solution = new Solution();
        ListNode listNode0 = ListNode.createTestData("[1,3,5,7,9]");
        ListNode listNode1 = ListNode.createTestData("[2,4,6,8,10]");
        ListNode.print(listNode0);
        ListNode.print(listNode1);
        ListNode.print(solution.mergeTwoLists(listNode0, listNode1));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNodeMe listNode0 = ListNodeMe.createTestData("[1,3,5,7,9]");
        ListNodeMe listNode1 = ListNodeMe.createTestData("[1,2,4,6,8,10]");
        ListNodeMe.print(listNode0);
        ListNodeMe.print(listNode1);
        ListNodeMe.print(solution.mergeTwoLists(listNode0, listNode1));
    }

    private ListNodeMe mergeTwoLists(ListNodeMe listNode0, ListNodeMe listNode1) {
        ListNodeMe header = new ListNodeMe(-1);
        ListNodeMe temp = header;
        while (listNode0 != null && listNode1 != null) {
            if (listNode0.data < listNode1.data) {
                temp.next = listNode0;
                listNode0 = listNode0.next;
            } else {
                temp.next = listNode1;
                listNode1 = listNode1.next;
            }
            temp = temp.next;
        }
        temp.next = listNode0 == null ? listNode1 : listNode0;
        return header.next;
    }
}