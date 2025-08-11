package ch10.ex5;

import java.io.*;
import java.util.*;

// 직렬화 가능하고 비교 가능한 객체를 위한 저장소
public class PersistentSortedStorage<T extends Serializable & Comparable<T>> {
    private List<T> items;
    private String filename;

    public PersistentSortedStorage(String filename) {
        this.filename = filename;
        this.items = new ArrayList<>();
        loadFromFile();
    }

    // 요소 추가 (정렬된 순서 유지)
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("null 값은 추가할 수 없습니다");
        }

        int insertIndex = Collections.binarySearch(items, item);
        if (insertIndex < 0) {
            insertIndex = -insertIndex - 1;
        }
        items.add(insertIndex, item);

        saveToFile(); // 자동 저장
    }

    // 요소 제거
    public boolean remove(T item) {
        boolean removed = items.remove(item);
        if (removed) {
            saveToFile(); // 자동 저장
        }
        return removed;
    }

    // 검색
    public boolean contains(T item) {
        return Collections.binarySearch(items, item) >= 0;
    }

    public int indexOf(T item) {
        int index = Collections.binarySearch(items, item);
        return index >= 0 ? index : -1;
    }

    // 범위 검색
    public List<T> getRange(T from, T to) {
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (item.compareTo(from) >= 0 && item.compareTo(to) <= 0) {
                result.add(item);
            }
        }

        return result;
    }

    // 기본 정보
    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    // 파일 저장
    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            oos.writeObject(items);
        } catch (IOException e) {
            System.err.println("저장 실패: " + e.getMessage());
        }
    }

    // 파일 로드
    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(filename))) {
            items = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            // 파일이 없으면 빈 리스트로 시작
            items = new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("로드 실패: " + e.getMessage());
            items = new ArrayList<>();
        }
    }

    // 수동 저장
    public void save() {
        saveToFile();
    }

    // 파일에서 다시 로드
    public void reload() {
        loadFromFile();
    }

    @Override
    public String toString() {
        return "PersistentSortedStorage" + items.toString();
    }

    public static void main(String[] args) {
        // String 저장소 테스트
        PersistentSortedStorage<String> stringStorage =
                new PersistentSortedStorage<>("strings.dat");

        System.out.println("초기 문자열 저장소: " + stringStorage);

        // 데이터 추가
        stringStorage.add("banana");
        stringStorage.add("apple");
        stringStorage.add("cherry");
        stringStorage.add("date");

        System.out.println("추가 후: " + stringStorage);

        // 검색
        System.out.println("'cherry' 포함? " + stringStorage.contains("cherry"));
        System.out.println("'apple' 인덱스: " + stringStorage.indexOf("apple"));

        // 범위 검색
        List<String> range = stringStorage.getRange("banana", "date");
        System.out.println("'banana'~'date' 범위: " + range);

        // Integer 저장소 테스트
        System.out.println("\n" + "=".repeat(40));
        PersistentSortedStorage<Integer> intStorage =
                new PersistentSortedStorage<>("integers.dat");

        System.out.println("초기 정수 저장소: " + intStorage);

        // 데이터 추가
        intStorage.add(5);
        intStorage.add(2);
        intStorage.add(8);
        intStorage.add(1);
        intStorage.add(9);

        System.out.println("추가 후: " + intStorage);

        // 제거
        intStorage.remove(5);
        System.out.println("5 제거 후: " + intStorage);

        // 새로운 인스턴스로 테스트 (파일에서 로드)
        PersistentSortedStorage<Integer> intStorage2 =
                new PersistentSortedStorage<>("integers.dat");
        System.out.println("새 인스턴스 로드: " + intStorage2);

        // 정리
        new File("strings.dat").delete();
        new File("integers.dat").delete();
    }
}