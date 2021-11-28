package com.blankj.easy._107;


import com.blankj.structure.TreeNode;
import com.blankj.structure.TreeNodeMe;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.lang.System.out;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/09
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper2(list, root, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) { // 每经过一层添加一个list
            list.add(0, new LinkedList<>());
        }
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    private void helper2(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) { // 每经过一层添加一个list
            list.add(0, new LinkedList<>());
        }
        helper2(list, root.left, level + 1);
        helper2(list, root.right, level + 1);
        out.print(root.val + " "); // 在这里控制(前中后,指的是中间节点的访问顺序)序
        list.get(list.size() - level - 1).add(root.val);
    }

    public static void main2(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.levelOrderBottom(TreeNode.createTestData("[]")));
        List<List<Integer>> lists = solution.levelOrderBottom(TreeNode.createTestData("[1,2,2,3,4,4,3]"));
//        out.println(lists);
//        System.out.println(solution.levelOrderBottom(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));
    }

    /**
     *        0
     *      /  \
     *     1    2
     *    / \  / \
     *   3  4 5  6
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNodeMe treeNodes = TreeNodeMe.createTestData("[0,1,2,3,4,5,6]");
        List<List<Integer>> lists = solution.depthSearch(treeNodes);
//        out.println(lists);
        solution.levelSearch(treeNodes);
    }

    public List<List<Integer>> depthSearch(TreeNodeMe root) {
        List<List<Integer>> list = new LinkedList<>();
        out.print("深度搜索: ");
        depth(root);
        out.println();
        return list;
    }

    /**
     * 这里就是深度遍历(也就是前序遍历)
     * @param root
     */
    private void depth(TreeNodeMe root) {
        if (root == null) return;
        out.print(root.value + " ");
        depth(root.left);
        depth(root.right);

    }

    /**
     * 广度 0 1 2 3 4 5 6
     * @param root
     */
    private void levelSearch(TreeNodeMe root) {
        if (root == null) return;
        Queue<TreeNodeMe> queue = new ArrayDeque();
        queue.add(root);
        out.print("广度搜索: ");
        while (!queue.isEmpty()) {
            TreeNodeMe header = queue.remove();
            out.print(header.value + " ");
            if (header.left != null) {
                queue.add(header.left);
            }
            if (header.right != null) {
                queue.add(header.right);
            }
        }
    }

}
