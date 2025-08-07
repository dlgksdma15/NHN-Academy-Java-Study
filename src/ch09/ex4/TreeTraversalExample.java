package ch09.ex4;

import java.util.LinkedList;

public class TreeTraversalExample {

    // 전위 순회 (루트 → 왼쪽 → 오른쪽)
    public static void preorder(TreeNode root) {
        // TODO 1: root가 null이면 리턴
        // TODO 2: 현재 노드의 데이터 출력
        // TODO 3: 왼쪽 서브트리 순회
        // TODO 4: 오른쪽 서브트리 순회
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 중위 순회 (왼쪽 → 루트 → 오른쪽)
    public static void inorder(TreeNode root) {
        // TODO 1: root가 null이면 리턴
        // TODO 2: 왼쪽 서브트리 순회
        // TODO 3: 현재 노드의 데이터 출력
        // TODO 4: 오른쪽 서브트리 순회
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);

    }

    // 후위 순회 (왼쪽 → 오른쪽 → 루트)
    public static void postorder(TreeNode root) {
        // TODO 1: root가 null이면 리턴
        // TODO 2: 왼쪽 서브트리 순회
        // TODO 3: 오른쪽 서브트리 순회
        // TODO 4: 현재 노드의 데이터 출력
        if(root == null){
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // 레벨 순회 (너비 우선 탐색)
    public static void levelOrder(TreeNode root) {
        // TODO 1: root가 null이면 리턴

        // TODO 2: 큐 생성하고 root를 큐에 추가

        // TODO 3: 큐가 비지 않은 동안 반복:
        //   - 큐에서 노드를 꺼내고 데이터 출력
        //   - 왼쪽 자식이 있으면 큐에 추가
        //   - 오른쪽 자식이 있으면 큐에 추가
        if(root == null){
            return ;
        }
        LinkedList<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            TreeNode current = que.poll();
            System.out.print(current.data + " ");
            if(current.left != null){
                que.add(current.left);
            }
            if(current.right != null){
                que.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6))
        );

        System.out.println("전위 순회: ");
        preorder(root);  // 1 2 4 5 3 6

        System.out.println("\n중위 순회: ");
        inorder(root);   // 4 2 5 1 3 6

        System.out.println("\n후위 순회: ");
        postorder(root); // 4 5 2 6 3 1

        System.out.println("\n레벨 순회: ");
        levelOrder(root); // 1 2 3 4 5 6
    }
}