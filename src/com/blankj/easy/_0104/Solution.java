package com.blankj.easy._104;


import com.blankj.structure.TreeNode;
import com.blankj.structure.TreeNodeMe;

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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main_author(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxDepth(TreeNode.createTestData("[]")));
        TreeNode rootNode = TreeNode.createTestData("[1,2,2,3,4,4,3]");
        int depth = solution.maxDepth(rootNode);
        out.println(depth);
        TreeNode.print(rootNode);
//        System.out.println(solution.maxDepth(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        TreeNodeMe rootNode = TreeNodeMe.createTestData("[1,2,2,3,4,4,3,5,6]");
        TreeNodeMe rootNode = TreeNodeMe.createTestData("[0,1,2,3,4]");
        int depth = solution.maxDepthMe(rootNode);
        out.println(depth);
//        TreeNodeMe.print(rootNode);

    }

    /**
     * 深度搜索
     * 0 -> 1 -> 3 -> 3.left return 1  -> 3.right return 1-> max(1,1) ->
     * 1.left return 2 -> 4 -> 4.left is null return 1 -> 4.right is null return 1 ->
     * -> max(1, 1) - > 1.right return 2 -> max.(2, 2) return 2 ->
     * 0.left return 3 -> 2 -> 2.left -> 2.left return 1 -> 2.right -> 2.right return 1
     * -> max(1, 1) ->0.right return 2 -> max(3, 2) -> return 3
     * @param root
     * @return
     */
    public int maxDepthMe(TreeNodeMe root) {
        if (root == null) {
            return 0;
        }
        out.println("经过了此节点值为:" +root.value);
        int leftDepth = maxDepthMe(root.left) + 1;
        int rightDepth = maxDepthMe(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }

}
