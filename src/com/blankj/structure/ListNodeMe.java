package com.blankj.structure;

import static java.lang.System.out;

public class ListNodeMe {
    public int data;
    public ListNodeMe next;

    public ListNodeMe(int data) {
        this.data = data;
    }

    /**
     * 创建测试数据
     *
     * @param data [XX,XX,XX]
     * @return {@link ListNode}
     */
    public static ListNodeMe createTestData(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String substring = data.substring(1, data.length()-1);
        out.println(substring);
        String[] arr = substring.split(",");
        ListNodeMe[] nodeArr = new ListNodeMe[arr.length];
        nodeArr[0] = new ListNodeMe(Integer.parseInt(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            nodeArr[i] = new ListNodeMe(Integer.parseInt(arr[i]));
            nodeArr[i-1].next = nodeArr[i];
        }
        return nodeArr[0];
    }

    /**
     * 创建带有环的链表
     * @param data
     * @return
     */
    public static ListNodeMe createCirlceList(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String substring = data.substring(1, data.length()-1);
        out.println(substring);
        String[] arr = substring.split(",");
        ListNodeMe[] nodeArr = new ListNodeMe[arr.length];
        nodeArr[0] = new ListNodeMe(Integer.parseInt(arr[0]));
        for (int i = 1; i < arr.length; i++) {
            nodeArr[i] = new ListNodeMe(Integer.parseInt(arr[i]));
            nodeArr[i-1].next = nodeArr[i];
        }
        nodeArr[arr.length - 1].next = nodeArr[0];
        return nodeArr[0];
    }

    public static void print(ListNodeMe nodeMe) {
        while (nodeMe != null) {
            out.print(nodeMe.data + " ");
            nodeMe = nodeMe.next;
        }
        out.println();
    }

    public static void main(String[] args) {
        ListNodeMe nodeMe = ListNodeMe.createTestData("[1,3,5,7,9]");
        print(nodeMe);
    }
}
