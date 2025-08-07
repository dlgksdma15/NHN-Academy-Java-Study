package ch09.ex4;

class BinarySearchTree {
    private TreeNode root;

    private static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    // 삽입 (재귀적)
    public void insert(int value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode node, int value) {
        // TODO 1: 기저 사례 - node가 null이면 새 TreeNode 생성하여 반환
        if (node == null) {
            return new TreeNode(value);
        }

        // TODO 2: value가 node.data보다 작으면 왼쪽 서브트리에 삽입
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        }
        // TODO 3: value가 node.data보다 크면 오른쪽 서브트리에 삽입
        else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        // TODO 4: 같으면 중복이므로 무시 (작업 없음)

        // TODO 5: 현재 노드 반환
        return node;
    }

    // 삽입 (반복적)
    public void insertIterative(int value) {
        if (root == null) {
            root = new TreeNode(value);
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            if (value < current.data) {
                current = current.left;
            } else if (value > current.data) {
                current = current.right;
            } else {
                return; // 중복값
            }
        }

        if (value < parent.data) {
            parent.left = new TreeNode(value);
        } else {
            parent.right = new TreeNode(value);
        }
    }

    // 검색
    public boolean contains(int value) {
        return containsRec(root, value);
    }

    private boolean containsRec(TreeNode node, int value) {
        // TODO 1: 기저 사례 - node가 null이면 false 반환
        if (node == null) {
            return false;
        }

        // TODO 2: value와 node.data가 같으면 true 반환
        if (value == node.data) {
            return true;
        }

        // TODO 3: value가 node.data보다 작으면 왼쪽 서브트리에서 검색
        if (value < node.data) {
            return containsRec(node.left, value);
        }
        // TODO 4: 그렇지 않으면 오른쪽 서브트리에서 검색
        else {
            return containsRec(node.right, value);
        }
    }

    // 최소값 찾기
    public int findMin() {
        if (root == null) throw new IllegalStateException("트리가 비어있습니다");
        return findMinNode(root).data;
    }

    private TreeNode findMinNode(TreeNode node) {
        // TODO: 가장 왼쪽 노드를 찾을 때까지 왼쪽으로 이동
        // 힌트: while 루프를 사용하여 node.left가 null이 아닌 동안 계속 이동
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // 최대값 찾기
    public int findMax() {
        if (root == null) throw new IllegalStateException("트리가 비어있습니다");

        TreeNode node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    // 삭제 (복잡한 연산)
    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private TreeNode deleteRec(TreeNode node, int value) {
        if (node == null) return null;

        if (value < node.data) {
            node.left = deleteRec(node.left, value);
        } else if (value > node.data) {
            node.right = deleteRec(node.right, value);
        } else {
            // 삭제할 노드를 찾음

            // 경우 1: 잎 노드
            if (node.left == null && node.right == null) {
                return null;
            }

            // 경우 2: 자식이 하나인 노드
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // 경우 3: 자식이 둘인 노드
            // 오른쪽 서브트리의 최소값으로 대체
            TreeNode minNode = findMinNode(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data);
        }

        return node;
    }

    // 중위 순회로 정렬된 출력
    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(TreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // 재귀 삽입 테스트
        System.out.println("재귀적 삽입 후 중위 순회:");
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);
        bst.printInOrder(); // 20 30 40 50 60 70 80

        System.out.println("\n--- 검색 테스트 ---");
        System.out.println("50 포함? " + bst.contains(50)); // true
        System.out.println("10 포함? " + bst.contains(10)); // false

        System.out.println("\n--- 최소/최대값 테스트 ---");
        System.out.println("최소값: " + bst.findMin()); // 20
        System.out.println("최대값: " + bst.findMax()); // 80

        System.out.println("\n--- 삭제 테스트 ---");
        System.out.println("60 삭제 (자식 하나)");
        bst.delete(60);
        System.out.print("삭제 후 중위 순회: ");
        bst.printInOrder(); // 20 30 40 50 70 80

        System.out.println("\n50 삭제 (자식 둘)");
        bst.delete(50);
        System.out.print("삭제 후 중위 순회: ");
        bst.printInOrder(); // 20 30 40 70 80
    }
}