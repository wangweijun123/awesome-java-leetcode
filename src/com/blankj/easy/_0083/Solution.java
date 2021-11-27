package com.blankj.easy._083;

import com.blankj.structure.ListNode;
import com.blankj.structure.ListNodeMe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/10
 *     desc  :
 * </pre>
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main2(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));
    }

    public static void main_me(String[] args) {
        Solution solution = new Solution();
        // 升序的链表排重很好做了
        ListNodeMe listNode1 = ListNodeMe.createTestData("[1,2,2,4,4,6,8,10]");
        ListNodeMe.print(listNode1);
        solution.deleteDuplicates2(listNode1);
    }

    public static void main3(String[] args) {
        Solution solution = new Solution();
//        ListNodeMe listNode1 = ListNodeMe.createTestData("[1,2,2,4,4,6,8,10]");
        ListNodeMe listNode1 = ListNodeMe.createCirlceList("[1,2,2,4,4,6,8,10]");
        boolean looperList = solution.isLooperList(listNode1);
        out.println("is cirlce list ? " + looperList);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNodeMe listNode1 = ListNodeMe.createTestData("[1,2,3,4,5,6,8,10]");
//        ListNodeMe.print(solution.reverseList2(listNode1));
        listNode1 = solution.deleteByIndex(listNode1, 3);

        ListNodeMe.print(listNode1);
    }

    private void deleteDuplicates2(ListNodeMe listNode1) {
        ListNodeMe temp = listNode1;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        ListNodeMe.print(listNode1);
    }

    /**
     * 判断是否有环
     * @param temp
     * @return
     */
    private boolean isLooperList(ListNodeMe temp) {
        Object o = new Object();
        Map<ListNodeMe, Object> map = new HashMap<>();
        while (temp != null) {
            Object put = map.put(temp, o);
            if (put != null) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static ListNodeMe reverseList2(ListNodeMe current) {
        ListNodeMe pre = null;
        ListNodeMe next = null;
        while (current != null) {
            // 第一步: 保存下一个节点,因为需要打断
            next = current.next;
            // 第二步:打断
            current.next = pre;

            //后面两步为了下一次循环做准备
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * 删除第index个元素, 从0开始  "[1,2,3,4,5,6,8,10]"  2
     * @param current
     * @param index
     */
    public ListNodeMe deleteByIndex(ListNodeMe current, int index) { // 2
        ListNodeMe orign = current;
        if (index == 0) {
            return orign.next;
        }
        ListNodeMe pre = null;
        while (index > 0) {
            pre = orign;
            orign = orign.next;
            index--;
        }
        pre.next = orign.next;
        orign.next = null;
        return current;
    }

    /**
     * 反转列表
     * @param current
     * @return
     */
    public static ListNodeMe reverseList(ListNodeMe current) {
        ListNodeMe pre = null;
        ListNodeMe next = null;
        while (current != null) {
            next = current.next;
            current.next = pre;

            pre = current;
            current = next;
        }
        return pre;
    }
}
