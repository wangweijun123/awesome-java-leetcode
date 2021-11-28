package com.blankj.easy._107;


import com.blankj.structure.TreeNode;
import com.blankj.structure.TreeNodeMe;

import java.util.LinkedList;
import java.util.List;

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.levelOrderBottomMe(TreeNodeMe.createTestData("[1,2,2,3,4,4,3]"));
//        out.println(lists);
    }

    public List<List<Integer>> levelOrderBottomMe(TreeNodeMe root) {
        List<List<Integer>> list = new LinkedList<>();
        helperMe(root);
        return list;
    }

    private void helperMe(TreeNodeMe root) {
        if (root == null) return;
        out.print(root.value + " ");
        helperMe(root.left);
        helperMe(root.right);

    }

}
