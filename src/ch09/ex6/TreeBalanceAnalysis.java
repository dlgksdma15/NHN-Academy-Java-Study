package ch09.ex6;

import java.util.*;

public class TreeBalanceAnalysis {

    static class TreeNode {
        double item;
        TreeNode left, right;

        TreeNode(double item) {
            this.item = item;
        }
    }

    static class TreeAnalyzer {
        private int leafCount;
        private int totalLeafDepth;
        private int maxLeafDepth;

        /**
         * 트리 분석 수행
         */
        public void analyze(TreeNode root) {
            leafCount = 0;
            totalLeafDepth = 0;
            maxLeafDepth = 0;

            analyzeNode(root, 0);
        }

        private void analyzeNode(TreeNode node, int depth) {
            if (node == null) return;

            if (node.left == null && node.right == null) {
                // 리프 노드
                leafCount++;
                totalLeafDepth += depth;
                maxLeafDepth = Math.max(maxLeafDepth, depth);
            } else {
                // 내부 노드
                analyzeNode(node.left, depth + 1);
                analyzeNode(node.right, depth + 1);
            }
        }

        public double getAverageLeafDepth() {
            if (leafCount == 0) return 0;
            return (double) totalLeafDepth / leafCount;
        }

        public int getMaxLeafDepth() {
            return maxLeafDepth;
        }

        public int getLeafCount() {
            return leafCount;
        }

        /**
         * 트리의 높이 계산
         */
        public static int getHeight(TreeNode node) {
            if (node == null) return -1;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        /**
         * 트리가 균형잡혀 있는지 확인
         */
        public static boolean isBalanced(TreeNode node) {
            return checkBalance(node) != -1;
        }

        private static int checkBalance(TreeNode node) {
            if (node == null) return 0;

            int leftHeight = checkBalance(node.left);
            if (leftHeight == -1) return -1;

            int rightHeight = checkBalance(node.right);
            if (rightHeight == -1) return -1;

            if (Math.abs(leftHeight - rightHeight) > 1) return -1;

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    /**
     * 무작위 이진 정렬 트리 생성
     */
    public static TreeNode createRandomBST(int nodeCount) {
        TreeNode root = null;
        Random random = new Random();

        for (int i = 0; i < nodeCount; i++) {
            double value = random.nextDouble() * 1000;
            root = insert(root, value);
        }

        return root;
    }

    private static TreeNode insert(TreeNode node, double value) {
        if (node == null) {
            return new TreeNode(value);
        }

        if (value < node.item) {
            node.left = insert(node.left, value);
        } else {
            node.right = insert(node.right, value);
        }

        return node;
    }

    /**
     * 균형 분석 실행
     */
    public static void runBalanceExperiment(int trials, int nodeCount) {
        System.out.println("=== 트리 균형 실험 ===");
        System.out.printf("노드 수: %d, 시도 횟수: %d%n", nodeCount, trials);
        System.out.println("\n완벽히 균형잡힌 트리의 높이: " +
                (int)(Math.log(nodeCount) / Math.log(2)));

        double totalAvgDepth = 0;
        int totalMaxDepth = 0;
        int balancedCount = 0;

        for (int i = 0; i < trials; i++) {
            TreeNode root = createRandomBST(nodeCount);
            TreeAnalyzer analyzer = new TreeAnalyzer();
            analyzer.analyze(root);

            totalAvgDepth += analyzer.getAverageLeafDepth();
            totalMaxDepth += analyzer.getMaxLeafDepth();

            if (TreeAnalyzer.isBalanced(root)) {
                balancedCount++;
            }
        }

        System.out.printf("\n평균 리프 깊이: %.2f%n", totalAvgDepth / trials);
        System.out.printf("평균 최대 깊이: %.2f%n", (double)totalMaxDepth / trials);
        System.out.printf("균형잡힌 트리 비율: %.1f%%%n",
                (double)balancedCount / trials * 100);
    }

    /**
     * 트리 시각화 (작은 트리용)
     */
    public static void printTree(TreeNode root) {
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(TreeNode node, String prefix, boolean isLast) {
        if (node == null) return;

        System.out.println(prefix + (isLast ? "└── " : "├── ") +
                String.format("%.1f", node.item));

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeHelper(node.left, prefix + (isLast ? "    " : "│   "),
                        node.right == null);
            } else {
                System.out.println(prefix + (isLast ? "    " : "│   ") +
                        "└── null");
            }

            if (node.right != null) {
                printTreeHelper(node.right, prefix + (isLast ? "    " : "│   "),
                        true);
            } else {
                System.out.println(prefix + (isLast ? "    " : "│   ") +
                        "└── null");
            }
        }
    }

    public static void main(String[] args) {
        // 1023개 노드로 실험
        runBalanceExperiment(100, 1023);

        System.out.println("\n=== 다양한 크기의 트리 비교 ===");
        int[] sizes = {15, 31, 63, 127, 255, 511, 1023};

        System.out.println("크기\t이상적 높이\t실제 평균 깊이\t실제 최대 깊이");
        for (int size : sizes) {
            TreeNode root = createRandomBST(size);
            TreeAnalyzer analyzer = new TreeAnalyzer();
            analyzer.analyze(root);

            int idealHeight = (int)(Math.log(size) / Math.log(2));
            System.out.printf("%d\t%d\t\t%.2f\t\t%d%n",
                    size, idealHeight,
                    analyzer.getAverageLeafDepth(),
                    analyzer.getMaxLeafDepth());
        }

        // 작은 트리 시각화
        System.out.println("\n=== 15개 노드 트리 예시 ===");
        TreeNode smallTree = createRandomBST(15);
        printTree(smallTree);
    }
}