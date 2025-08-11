package ch09.ex6;

import java.util.*;

public class TreeLevelOrder {

    static class TreeNode {
        int item;
        TreeNode left, right;

        TreeNode(int item) {
            this.item = item;
        }
    }

    // 큐 구현 (연결 리스트 기반)
    static class Queue<T> {
        private static class Node<T> {
            T data;
            Node<T> next;

            Node(T data) {
                this.data = data;
            }
        }

        private Node<T> front, rear;
        private int size;

        public void enqueue(T item) {
            Node<T> newNode = new Node<>(item);
            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }
            size++;
        }

        public T dequeue() {
            if (isEmpty()) {
                throw new NoSuchElementException("큐가 비어있습니다");
            }
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            size--;
            return data;
        }

        public boolean isEmpty() {
            return front == null;
        }

        public int size() {
            return size;
        }
    }

    /**
     * 큐를 사용한 레벨 순서 순회
     */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        System.out.println("레벨 순서 순회:");
        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.print(node.item + " ");

            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        System.out.println();
    }

    /**
     * 레벨별로 출력
     */
    public static void levelByLevel(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);

        System.out.println("레벨별 출력:");
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("레벨 " + level + ": ");

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.dequeue();
                System.out.print(node.item + " ");

                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }
            System.out.println();
            level++;
        }
    }

    /**
     * 지그재그 레벨 순서 순회
     */
    public static void zigzagLevelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new Queue<>();
        queue.enqueue(root);
        boolean leftToRight = true;

        System.out.println("지그재그 순회:");

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.dequeue();
                levelValues.add(node.item);

                if (node.left != null) {
                    queue.enqueue(node.left);
                }
                if (node.right != null) {
                    queue.enqueue(node.right);
                }
            }

            if (!leftToRight) {
                Collections.reverse(levelValues);
            }

            for (int val : levelValues) {
                System.out.print(val + " ");
            }

            leftToRight = !leftToRight;
        }
        System.out.println();
    }

    /**
     * 다양한 순회 방법 비교
     */
    public static void compareTraversals(TreeNode root) {
        System.out.println("=== 순회 방법 비교 ===");

        // 전위 순회 (재귀)
        System.out.print("전위 순회: ");
        preorderTraversal(root);
        System.out.println();

        // 중위 순회 (재귀)
        System.out.print("중위 순회: ");
        inorderTraversal(root);
        System.out.println();

        // 후위 순회 (재귀)
        System.out.print("후위 순회: ");
        postorderTraversal(root);
        System.out.println();

        // 레벨 순서 순회
        levelOrderTraversal(root);
    }

    private static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.item + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    private static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.item + " ");
            inorderTraversal(node.right);
        }
    }

    private static void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.item + " ");
        }
    }

    /**
     * 샘플 트리 생성
     */
    public static TreeNode createSampleTree() {
        /*
                 1
                / \
               2   3
              / \ / \
             4  5 6  7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = createSampleTree();

        // 다양한 순회 방법 비교
        compareTraversals(root);

        System.out.println();

        // 레벨별 출력
        levelByLevel(root);

        System.out.println();

        // 지그재그 순회
        zigzagLevelOrder(root);
    }
}