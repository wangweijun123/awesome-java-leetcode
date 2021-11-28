package com.blankj.structure;

public class TreeNodeMe {
    public int value;
    public TreeNodeMe left;
    public TreeNodeMe right;

    public TreeNodeMe(int value) {
        this.value = value;
    }

    public static TreeNodeMe createTestData(String data) {
        // [1,2,2,3,4,4,3]
        data =  data.substring(1, data.length() - 1);
        String[] split = data.split(",");
        int len = split.length;
        TreeNodeMe treeNodes[] = new TreeNodeMe[len];
        // 给数组赋值
        for (int i = 0; i < len; i++) {
            treeNodes[i] = new TreeNodeMe(Integer.parseInt(split[i])); // 异常未捕获
        }
        // 建立引用关系
        for (int i = 0; i < len; i++) {
            int leftIndex = i * 2 + 1;
            int rightIndex = leftIndex + 1;
            if (leftIndex < len) {
                treeNodes[i].left = treeNodes[leftIndex];
            }
            if (rightIndex < len) {
                treeNodes[i].right = treeNodes[rightIndex];
            }
        }
        return treeNodes[0];
    }

    private static final String space = "      ";

    /**
     * 竖向打印二叉树
     *
     * @param root 二叉树根节点
     */
    public static void print(TreeNodeMe root) {
        print(root, 0);
    }

    private static void print(TreeNodeMe node, int deep) {
        if (node == null) {
            printSpace(deep);
            System.out.println("#");
            return;
        }
        print(node.right, deep + 1);
        printSpace(deep);
        printNode(node.value);
        print(node.left, deep + 1);
    }

    private static void printSpace(int count) {
        for (int i = 0; i < count; i++) {
            System.out.printf(space);
        }
    }

    private static void printNode(int val) {
        StringBuilder res = new StringBuilder(val + "<");
        int spaceNum = space.length() - res.length();
        for (int i = 0; i < spaceNum; i++) {
            res.append(" ");
        }
        System.out.println(res);
    }
}
