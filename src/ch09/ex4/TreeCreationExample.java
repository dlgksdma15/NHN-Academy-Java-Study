package ch09.ex4;

public class TreeCreationExample {
    public static void main(String[] args) {
        // 방법 1: 개별 노드 생성 후 연결
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 방법 2: 중첩된 생성자 사용
        TreeNode tree = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3,
                        null,
                        new TreeNode(6)
                )
        );

        System.out.println("트리가 생성되었습니다!");
        printTree(tree);
    }

    // 트리 시각화 (간단한 버전)
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") + node.data);

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeHelper(node.left, prefix + (isLast ? "    " : "│   "), false);
            }
            if (node.right != null) {
                printTreeHelper(node.right, prefix + (isLast ? "    " : "│   "), true);
            }
        }
    }
}