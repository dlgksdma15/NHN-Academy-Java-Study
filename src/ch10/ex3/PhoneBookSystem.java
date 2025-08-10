package ch10.ex3;

import java.util.*;

public class PhoneBookSystem {

    private Map<String, String> phoneBook;
    private Map<String, Set<String>> reversePhoneBook;  // 전화번호 -> 이름들

    public PhoneBookSystem() {
        this.phoneBook = new TreeMap<>();  // 이름순 정렬
        this.reversePhoneBook = new HashMap<>();
    }

    // 전화번호 추가
    public void addContact(String name, String phoneNumber) {
        // TODO 3: 기존 번호가 있으면 역방향 맵에서 제거
        String oldPhoneNumber = phoneBook.get(name);
        if (oldPhoneNumber != null) {
            Set<String> names = reversePhoneBook.get(oldPhoneNumber);
            if (names != null) {
                names.remove(name);
                if (names.isEmpty()) {
                    reversePhoneBook.remove(oldPhoneNumber);
                }
            }
        }

        // TODO 4: 새 번호 추가
        // - phoneBook에 이름-번호 매핑 추가
        // - reversePhoneBook에 번호-이름 Set 매핑 추가
        phoneBook.put(name, phoneNumber);
        reversePhoneBook.computeIfAbsent(phoneNumber, k -> new HashSet<>()).add(name);
    }

    // 이름으로 번호 찾기
    public String getNumber(String name) {
        return phoneBook.get(name);
    }

    // 번호로 이름 찾기
    public Set<String> getNames(String phoneNumber) {
        return reversePhoneBook.getOrDefault(phoneNumber, Collections.emptySet());
    }

    // 이름으로 검색
    public List<Map.Entry<String, String>> searchByName(String prefix) {
        List<Map.Entry<String, String>> results = new ArrayList<>();

        // TODO 5: TreeMap의 subMap을 사용하여 prefix로 시작하는 항목 찾기
        // 힌트: phoneBook이 TreeMap 인스턴스인지 확인
        //       prefix로 시작하여 prefix+"힣"으로 끝나는 범위 사용
        if (phoneBook instanceof TreeMap) {
            String startKey = prefix;
            String endKey = prefix + "힣"; // 한글의 마지막 글자 유니코드

            SortedMap<String, String> subMap = ((TreeMap<String, String>) phoneBook).subMap(startKey, endKey);
            results.addAll(subMap.entrySet());
        }

        return results;
    }

    // 연락처 삭제
    public boolean removeContact(String name) {
        String phoneNumber = phoneBook.remove(name);
        if (phoneNumber != null) {
            Set<String> names = reversePhoneBook.get(phoneNumber);
            if (names != null) {
                names.remove(name);
                if (names.isEmpty()) {
                    reversePhoneBook.remove(phoneNumber);
                }
            }
            return true;
        }
        return false;
    }

    // 전체 목록
    public void printAll() {
        System.out.println("=== 전화번호부 ===");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // 중복 번호 찾기
    public Map<String, Set<String>> findDuplicateNumbers() {
        Map<String, Set<String>> duplicates = new HashMap<>();

        // TODO 6: reversePhoneBook에서 여러 이름이 있는 번호 찾기
        for (Map.Entry<String, Set<String>> entry : reversePhoneBook.entrySet()) {
            if (entry.getValue().size() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }

        return duplicates;
    }

    public static void main(String[] args) {
        PhoneBookSystem phoneBook = new PhoneBookSystem();

        // 연락처 추가
        phoneBook.addContact("김철수", "010-1234-5678");
        phoneBook.addContact("이영희", "010-2345-6789");
        phoneBook.addContact("박민수", "010-3456-7890");
        phoneBook.addContact("김영희", "010-1234-5678");  // 같은 번호
        phoneBook.addContact("정지원", "010-4567-8901");
        phoneBook.addContact("김민준", "010-5678-9012");

        // 전체 목록
        phoneBook.printAll();

        // 검색
        System.out.println("\n=== '김'으로 시작하는 연락처 ===");
        List<Map.Entry<String, String>> kimContacts = phoneBook.searchByName("김");
        for (Map.Entry<String, String> entry : kimContacts) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // 역방향 검색
        System.out.println("\n=== 010-1234-5678 사용자 ===");
        Set<String> users = phoneBook.getNames("010-1234-5678");
        System.out.println(users);

        // 중복 번호
        System.out.println("\n=== 중복 전화번호 ===");
        Map<String, Set<String>> duplicates = phoneBook.findDuplicateNumbers();
        for (Map.Entry<String, Set<String>> entry : duplicates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}