package ch09.ex4;

public class TreeTraversalApplications {

    // 트리의 모든 노드 합계 구하기
    public static int sumTree(TreeNode root) {
        // TODO 1: 기저 사례 - root가 null이면 0 반환
        // TODO 2: 현재 노드와 왼쪽, 오른쪽 서브트리의 합을 더해서 반환
        if(root == null){
            return 0;
        }
        return root.data + sumTree(root.left) + sumTree(root.right) ;
    }

    // 트리의 최대값 찾기
    public static int findMax(TreeNode root) {
        // TODO 1: 기저 사례 - root가 null이면 Integer.MIN_VALUE 반환
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int max = 0;
        // TODO 2: 왼쪽 서브트리의 최대값 구하기
        int maxLeft = findMax(root.left);
        // TODO 3: 오른쪽 서브트리의 최대값 구하기
        int maxRight = findMax(root.right);

        // TODO 4: 현재 노드, 왼쪽 최대값, 오른쪽 최대값 중 가장 큰 값 반환

        return root.data > Math.max(maxLeft,maxRight) ? root.data : maxRight > maxLeft ? maxRight : maxLeft; // 임시 반환값
    }

    // 특정 값이 트리에 있는지 확인
    public static boolean contains(TreeNode root, int target) {
        // TODO 1: 기저 사례 - root가 null이면 false 반환
        // TODO 2: 현재 노드의 값이 target과 같으면 true 반환

        // TODO 3: 왼쪽 또는 오른쪽 서브트리에 target이 있는지 확인
        if(root == null){
            return false;
        }
        if(root.data == target){
            return true;
        }
        boolean containsleft = contains(root.left,target);
        boolean containsright = contains(root.right,target);
        if(containsleft || containsright){
            return true;
        }else{
            return false;
        }
    }

    // 트리의 높이 구하기
    public static int height(TreeNode root) {
        // TODO 1: 기저 사례 - root가 null이면 0 반환
        // TODO 2: 1 + (왼쪽 서브트리와 오른쪽 서브트리 높이 중 큰 값) 반환
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left),height(root.right)); // 임시 반환값
    }

    // 잎 노드의 개수 세기
    public static int countLeaves(TreeNode root) {
        // TODO 1: 기저 사례 - root가 null이면 0 반환
        // TODO 2: 잎 노드인지 확인 (왼쪽, 오른쪽 자식이 모두 null)
        // TODO 3: 왼쪽과 오른쪽 서브트리의 잎 노드 개수를 더해서 반환
        int count = 0;
        if(root == null){
            return 0;
        }
        if(root.left == null || root.right == null){
            return 1;
        }

        return countLeaves(root.left) + countLeaves(root.right); // 임시 반환값
    }

    // 모든 경로 출력하기
    public static void printPaths(TreeNode root) {
        int[] path = new int[1000];
        printPathsHelper(root, path, 0);
    }

    private static void printPathsHelper(TreeNode node, int[] path, int pathLen) {
        if (node == null) return;

        path[pathLen] = node.data;
        pathLen++;

        if (node.left == null && node.right == null) {
            // 잎 노드에 도달하면 경로 출력
            System.out.print("경로: ");
            for (int i = 0; i < pathLen; i++) {
                System.out.print(path[i]);
                if (i < pathLen - 1) System.out.print(" → ");
            }
            System.out.println();
        } else {
            printPathsHelper(node.left, path, pathLen);
            printPathsHelper(node.right, path, pathLen);
        }
    }
    public static void main(String[] args) {
        /*
                 10
                /  \
               5    15
              / \     \
             3   7     20
            /
           1
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);
        root.left.left.left = new TreeNode(1);

        System.out.println("=== 트리 응용 메서드 테스트 ===");
        System.out.println("트리 노드의 총합: " + sumTree(root));
        System.out.println("트리의 최대값: " + findMax(root));
        System.out.println("트리가 7을 포함하는가? " + contains(root, 7));
        System.out.println("트리가 99를 포함하는가? " + contains(root, 99));
        System.out.println("트리의 높이: " + height(root));
        System.out.println("잎 노드의 개수: " + countLeaves(root));
        System.out.println("\n--- 모든 경로 출력 ---");
        printPaths(root);
    }
}