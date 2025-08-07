package ch09.ex4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

public class TreeAdvancedOperations {
    // TreeNode class for demonstration purposes
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // Check if two trees are identical
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // TODO 1: If both nodes are null, return true
        if (p == null && q == null) {
            return true;
        }
        // TODO 2: If only one of them is null, return false
        if (p == null || q == null) {
            return false;
        }

        // TODO 3: Check if the data is the same and the subtrees are also identical
        return (p.data == q.data)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    // Check if a tree is symmetric
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return t1.data == t2.data
                && isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    // Invert a tree (mirror image)
    public static TreeNode invertTree(TreeNode root) {
        // TODO 1: Base case - if root is null, return null
        if (root == null) {
            return null;
        }

        // TODO 2: Recursively invert the left and right subtrees
        TreeNode leftInverted = invertTree(root.left);
        TreeNode rightInverted = invertTree(root.right);

        // TODO 3: Swap the children
        root.left = rightInverted;
        root.right = leftInverted;

        // TODO 4: Return the current node
        return root;
    }

    // Convert a sorted array to a balanced BST
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        node.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return node;
    }

    // Flatten a tree into a linked list in preorder traversal order
    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = temp;
    }

    public static void main(String[] args) {
        System.out.println("--- isSameTree Test ---");
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        System.out.println("Tree p and q are same: " + isSameTree(p, q)); // true
        q.right = new TreeNode(3);
        System.out.println("Tree p and q are same: " + isSameTree(p, q)); // false

        System.out.println("\n--- invertTree Test ---");
        TreeNode treeToInvert = new TreeNode(4);
        treeToInvert.left = new TreeNode(2);
        treeToInvert.right = new TreeNode(7);
        treeToInvert.left.left = new TreeNode(1);
        treeToInvert.left.right = new TreeNode(3);
        treeToInvert.right.left = new TreeNode(6);
        treeToInvert.right.right = new TreeNode(9);
        System.out.println("Original tree (inorder): 1 2 3 4 6 7 9");
        TreeNode inverted = invertTree(treeToInvert);
        System.out.println("Inverted tree (inorder): 9 7 6 4 3 2 1"); // Example check
    }
}