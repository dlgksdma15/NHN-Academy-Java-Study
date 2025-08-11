package ch09.ex6;

import java.io.*;
import java.util.*;

public class WordSorterBST {

    // 이진 트리 노드
    static class TreeNode {
        String word;
        TreeNode left, right;

        TreeNode(String word) {
            this.word = word.toLowerCase();
        }
    }

    // 이진 정렬 트리
    static class BinarySearchTree {
        private TreeNode root;
        private int size;

        /**
         * 단어 삽입
         */
        public void insert(String word) {
            root = insertRec(root, word.toLowerCase());
        }

        private TreeNode insertRec(TreeNode node, String word) {
            // TODO 1: 기본 경우 - node가 null이면 새 TreeNode 생성하고 size 증가
            if (node == null) {
                size++;
                return new TreeNode(word);
            }

            // TODO 2: word와 node.word를 비교 (compareTo 사용)
            int compare = word.compareTo(node.word);

            // TODO 3: word가 더 작으면 왼쪽 서브트리에 삽입
            if (compare < 0) {
                node.left = insertRec(node.left, word);
            }
            // TODO 4: word가 더 크면 오른쪽 서브트리에 삽입
            else if (compare > 0) {
                node.right = insertRec(node.right, word);
            }
            // TODO 5: 같으면 중복이므로 무시
            // else { do nothing }

            // TODO 6: node 반환
            return node;
        }

        /**
         * 중위 순회로 정렬된 단어 출력
         */
        public void printInOrder(PrintWriter out) {
            printInOrderRec(root, out);
        }

        private void printInOrderRec(TreeNode node, PrintWriter out) {
            // TODO: 중위 순회로 단어 출력
            // 1. node가 null이 아니면:
            if (node != null) {
                //    - 왼쪽 서브트리 순회
                printInOrderRec(node.left, out);
                //    - 현재 노드의 단어 출력
                out.println(node.word);
                //    - 오른쪽 서브트리 순회
                printInOrderRec(node.right, out);
            }
        }

        /**
         * 단어를 리스트로 수집
         */
        public List<String> toList() {
            List<String> list = new ArrayList<>();
            collectWords(root, list);
            return list;
        }

        private void collectWords(TreeNode node, List<String> list) {
            if (node != null) {
                collectWords(node.left, list);
                list.add(node.word);
                collectWords(node.right, list);
            }
        }

        public int size() {
            return size;
        }
    }

    /**
     * 파일에서 단어를 읽어 정렬
     */
    public static void sortWordsFromFile(String inputFile, String outputFile) {
        BinarySearchTree bst = new BinarySearchTree();

        try (Scanner scanner = new Scanner(new File(inputFile))) {
            // 단어 읽기
            while (scanner.hasNext()) {
                String word = scanner.next();
                // 문장부호 제거
                word = word.replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    bst.insert(word);
                }
            }

            // 결과 출력
            try (PrintWriter out = new PrintWriter(outputFile)) {
                out.println("총 " + bst.size() + "개의 고유한 단어:");
                out.println();
                bst.printInOrder(out);
            }

            System.out.println("정렬 완료: " + outputFile);

        } catch (FileNotFoundException e) {
            System.err.println("파일을 찾을 수 없습니다: " + e.getMessage());
        }
    }

    /**
     * 성능 비교: BST vs ArrayList
     */
    public static void comparePerformance() {
        Random random = new Random();
        int[] sizes = {1000, 5000, 10000, 50000};

        System.out.println("=== BST vs ArrayList 성능 비교 ===");
        System.out.println("크기\tBST(ms)\tArrayList(ms)");

        for (int size : sizes) {
            // 랜덤 단어 생성
            String[] words = new String[size];
            for (int i = 0; i < size; i++) {
                words[i] = generateRandomWord(random, 5, 10);
            }

            // BST 테스트
            long startBST = System.currentTimeMillis();
            BinarySearchTree bst = new BinarySearchTree();
            for (String word : words) {
                bst.insert(word);
            }
            List<String> bstList = bst.toList();
            long endBST = System.currentTimeMillis();

            // ArrayList 테스트
            long startList = System.currentTimeMillis();
            List<String> arrayList = new ArrayList<>();
            for (String word : words) {
                if (!arrayList.contains(word)) {
                    arrayList.add(word);
                }
            }
            Collections.sort(arrayList);
            long endList = System.currentTimeMillis();

            System.out.printf("%d\t%d\t\t%d%n",
                    size, endBST - startBST, endList - startList);
        }
    }

    private static String generateRandomWord(Random random, int minLen, int maxLen) {
        int len = random.nextInt(maxLen - minLen + 1) + minLen;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char)('a' + random.nextInt(26)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 성능 비교
        comparePerformance();

        // 파일 정렬 예제
        // sortWordsFromFile("input.txt", "sorted_words.txt");
    }
}