package ch10.ex4;

import java.util.*;

public class InvertedIndex {
    // 문서 ID → 문서 내용
    private Map<Integer, String> documents;
    // 단어 → 문서 ID 집합
    private TreeMap<String, TreeSet<Integer>> index;

    public InvertedIndex() {
        documents = new HashMap<>();
        index = new TreeMap<>();
    }

    // 문서 추가
    public void addDocument(int docId, String content) {
        documents.put(docId, content);

        // 단어 추출 및 인덱싱
        String[] words = content.toLowerCase().split("\\W+");
        for (String word : words) {
            if (!word.isEmpty()) {
                index.computeIfAbsent(word, k -> new TreeSet<>())
                        .add(docId);
            }
        }
    }

    // 단일 단어 검색
    public Set<Integer> search(String word) {
        TreeSet<Integer> result = index.get(word.toLowerCase());
        return result != null ? new TreeSet<>(result) : new TreeSet<>();
    }

    // AND 검색 (모든 단어를 포함하는 문서)
    public Set<Integer> searchAnd(String... words) {
        if (words.length == 0) return new TreeSet<>();

        // TODO 23: 첫 번째 단어로 검색한 결과를 result에 저장
        Set<Integer> result = search(words[0]);
        if (result.isEmpty()) return new TreeSet<>();

        // TODO 24: 나머지 단어들에 대해 반복
        for (int i = 1; i < words.length; i++) {
            // - 각 단어로 검색한 결과와 result의 교집합 구하기 (retainAll 사용)
            Set<Integer> nextResult = search(words[i]);
            result.retainAll(nextResult);
            // - result가 비어있으면 반복 중단
            if (result.isEmpty()) {
                break;
            }
        }
        return result;
    }

    // OR 검색 (하나 이상의 단어를 포함하는 문서)
    public Set<Integer> searchOr(String... words) {
        // TODO 25: 빈 TreeSet<Integer> 생성
        Set<Integer> result = new TreeSet<>();

        // TODO 26: 각 단어에 대해 반복
        for (String word : words) {
            // - 단어로 검색한 결과를 result에 추가 (addAll 사용)
            result.addAll(search(word));
        }
        return result;
    }

    // NOT 검색 (특정 단어를 포함하지 않는 문서)
    public Set<Integer> searchNot(String word) {
        Set<Integer> allDocs = new TreeSet<>(documents.keySet());
        allDocs.removeAll(search(word));
        return allDocs;
    }

    // 검색 결과 출력
    public void printSearchResults(String query, Set<Integer> results) {
        System.out.println("\n검색어: " + query);
        System.out.println("결과: " + results.size() + "개 문서");

        for (Integer docId : results) {
            System.out.println("  문서 " + docId + ": " +
                    documents.get(docId));
        }
    }

    public static void main(String[] args) {
        InvertedIndex index = new InvertedIndex();

        // 문서 추가
        index.addDocument(1, "Java is a programming language");
        index.addDocument(2, "Python is also a programming language");
        index.addDocument(3, "Java is platform independent");
        index.addDocument(4, "Python has simple syntax");
        index.addDocument(5, "Both Java and Python are popular");

        // 단일 단어 검색
        index.printSearchResults("Java", index.search("Java"));

        // AND 검색
        index.printSearchResults("Java AND programming",
                index.searchAnd("Java", "programming"));

        // OR 검색
        index.printSearchResults("Java OR Python",
                index.searchOr("Java", "Python"));

        // NOT 검색
        index.printSearchResults("NOT Python",
                index.searchNot("Python"));

        // 복합 검색: programming AND (Java OR Python)
        Set<Integer> javaOrPython = index.searchOr("Java", "Python");
        Set<Integer> programming = index.search("programming");
        javaOrPython.retainAll(programming);
        index.printSearchResults("programming AND (Java OR Python)",
                javaOrPython);
    }
}