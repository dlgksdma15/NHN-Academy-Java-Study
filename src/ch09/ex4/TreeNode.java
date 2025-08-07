package ch09.ex4;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    // 생성자들
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }

    public static void main(String[] args) {
        // 리프 노드 생성 (자식 없는 노드)
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        // 중간 노드 생성 (자식을 가진 노드)
        TreeNode node2 = new TreeNode(2, node5, null);
        TreeNode node3 = new TreeNode(3, node6, node7);

        // 루트 노드 생성
        TreeNode root = new TreeNode(1, node2, node3);

        // 생성된 트리 구조 출력
        // 이진 트리 구조는 다음과 같습니다.
        //         1
        //       /   \
        //      2     3
        //     /     / \
        //    5     6   7

        System.out.println("루트 노드: " + root.data);
        System.out.println("루트의 왼쪽 자식: " + root.left.data);
        System.out.println("루트의 오른쪽 자식: " + root.right.data);

        System.out.println("루트의 왼쪽 자식의 왼쪽 자식: " + root.left.left.data);
        System.out.println("루트의 오른쪽 자식의 왼쪽 자식: " + root.right.left.data);
        System.out.println("루트의 오른쪽 자식의 오른쪽 자식: " + root.right.right.data);

        // toString() 메서드 테스트
        System.out.println("toString() 테스트 (node7): " + node7.toString());
    }
}