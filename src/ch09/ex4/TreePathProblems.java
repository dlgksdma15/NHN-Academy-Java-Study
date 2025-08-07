package ch09.ex4;

import java.util.ArrayList;
import java.util.List;

public class TreePathProblems {

    // 루트에서 잎까지의 모든 경로 반환
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfsPath(root, "", paths);
        }
        return paths;
    }

    private static void dfsPath(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(path + node.data);
            return;
        }

        if (node.left != null) {
            dfsPath(node.left, path + node.data + "->", paths);
        }
        if (node.right != null) {
            dfsPath(node.right, path + node.data + "->", paths);
        }
    }

    // 경로 합계가 특정 값인지 확인
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // TODO 1: 기저 사례 - root가 null이면 false 반환
        if (root == null) {
            return false;
        }

        // TODO 2: 잎 노드인 경우, 노드의 값이 targetSum과 같은지 확인
        if (root.left == null && root.right == null) {
            return targetSum == root.data;
        }

        // TODO 3: 왼쪽 또는 오른쪽 서브트리에서
        //         (targetSum - 현재 노드 값)을 만족하는 경로가 있는지 확인
        return hasPathSum(root.left, targetSum - root.data) || hasPathSum(root.right, targetSum - root.data);

    }
    // 모든 경로의 합계 중 최대값
    public static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        maxPathSumHelper(root, max);
        return max[0];
    }

    private static int maxPathSumHelper(TreeNode node, int[] max) {
        if (node == null) return 0;

        int left = Math.max(0, maxPathSumHelper(node.left, max));
        int right = Math.max(0, maxPathSumHelper(node.right, max));

        max[0] = Math.max(max[0], left + right + node.data);

        return Math.max(left, right) + node.data;
    }

    // 가장 낮은 공통 조상(LCA) 찾기
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // TODO 1: 기저 사례 - root가 null이거나 p 또는 q와 같으면 root 반환

        // TODO 2: 왼쪽과 오른쪽 서브트리에서 재귀적으로 LCA 찾기

        // TODO 3: 왼쪽과 오른쪽 모두에서 null이 아닌 값이 반환되면 현재 노드가 LCA
        // TODO 4: 한쪽만 null이 아니면 그 쪽의 값 반환

        return null; // 임시 반환값
    }
}