
import java.util.ArrayDeque;
import java.util.Stack;

public class TreeTest {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    TreeNode root;

    public TreeTest(int[] array) {
        root = makeBinaryTreeByArray(array, 1);
    }

    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array, int index) {
        if (index < array.length) {
            int value = array[index];
            if (value != 0) {
                TreeNode t = new TreeNode(value);
                array[index] = 0;
                t.left = makeBinaryTreeByArray(array, index * 2);
                t.right = makeBinaryTreeByArray(array, index * 2 + 1);
                return t;
            }
        }
        return null;
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        //     ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        // 0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0
        Stack<TreeNode> stack = new Stack();   //也可以用栈实现
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "    "); // 先访问自己
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) { // 最后访问左节点
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal() {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            System.out.print(node.value + "    ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }

    /**
     * 13
     * /  \
     * 65    5
     * /  \    \
     * 97  25   37
     * /    /\   /
     * 22   4 28 32
     */
    public static void main(String[] args) {
        int[] arr = {0, 13, 65, 5, 97, 25, 0, 37, 22, 0, 4, 28, 0, 0, 32, 0};
        TreeTest tree = new TreeTest(arr);
        tree.depthOrderTraversal(); //深度优先: 深度就是前序 13    65    97    22    25    4    28    5    37    32
        tree.levelOrderTraversal(); //广度优先:  13    65    5    97    25    37    22    4    28    32
    }

}
