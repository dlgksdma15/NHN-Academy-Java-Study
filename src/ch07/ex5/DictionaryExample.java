package ch07.ex5;

public class DictionaryExample {
    static class DictionaryEntry {
        String word;        // 영어 단어
        String meaning;     // 한국어 뜻
        String pronunciation; // 발음

        DictionaryEntry(String word, String meaning, String pronunciation) {
            this.word = word;
            this.meaning = meaning;
            this.pronunciation = pronunciation;
        }

        @Override
        public String toString() {
            return String.format("%s [%s] - %s", word, pronunciation, meaning);
        }
    }

    static class Dictionary {
        private DictionaryEntry[] entries;
        private int count;

        public Dictionary(int capacity) {
            entries = new DictionaryEntry[capacity];
            count = 0;
        }

        // 단어 추가
        public void addWord(String word, String meaning, String pronunciation) {
            entries[count++] = new DictionaryEntry(word.toLowerCase(), meaning, pronunciation);
        }

        // 단어 검색
        public DictionaryEntry lookupWord(String word) {
            String searchWord = word.toLowerCase();
            for (int i = 0; i < count; i++) {
                if (entries[i].word.equals(searchWord)) {
                    return entries[i];
                }
            }
            return null;
        }

        // 접두사로 시작하는 단어들 찾기
        public DictionaryEntry[] findWordsStartingWith(String prefix) {
            String searchPrefix = prefix.toLowerCase();

            // 먼저 개수 세기
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].word.startsWith(searchPrefix)) {
                    matchCount++;
                }
            }

            // 결과 배열 생성
            DictionaryEntry[] results = new DictionaryEntry[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].word.startsWith(searchPrefix)) {
                    results[resultIndex++] = entries[i];
                }
            }

            return results;
        }

        // 뜻에서 키워드 검색
        public DictionaryEntry[] findByMeaning(String keyword) {
            int matchCount = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].meaning.contains(keyword)) {
                    matchCount++;
                }
            }

            DictionaryEntry[] results = new DictionaryEntry[matchCount];
            int resultIndex = 0;
            for (int i = 0; i < count; i++) {
                if (entries[i].meaning.contains(keyword)) {
                    results[resultIndex++] = entries[i];
                }
            }

            return results;
        }
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(1000);

        // 샘플 단어들 추가
        dictionary.addWord("apple", "사과", "ˈæpl");
        dictionary.addWord("application", "신청, 지원", "ˌæplɪˈkeɪʃn");
        dictionary.addWord("apply", "적용하다, 신청하다", "əˈplaɪ");
        dictionary.addWord("book", "책", "bʊk");
        dictionary.addWord("computer", "컴퓨터", "kəmˈpjuːtər");
        dictionary.addWord("programming", "프로그래밍", "ˈproʊɡræmɪŋ");
        dictionary.addWord("java", "자바", "ˈdʒɑːvə");
        dictionary.addWord("algorithm", "알고리즘", "ˈælɡərɪðəm");

        // 단어 검색
        System.out.println("=== 단어 검색 ===");
        String[] searchWords = {"apple", "computer", "xyz"};

        for (String word : searchWords) {
            DictionaryEntry result = dictionary.lookupWord(word);
            if (result != null) {
                System.out.println(word + " → " + result);
            } else {
                System.out.println(word + " → 찾을 수 없음");
            }
        }

        // 접두사 검색
        System.out.println("\n=== 'app'로 시작하는 단어들 ===");
        DictionaryEntry[] appWords = dictionary.findWordsStartingWith("app");
        for (DictionaryEntry entry : appWords) {
            System.out.println(entry);
        }

        // 뜻으로 검색
        System.out.println("\n=== '프로그램'이 포함된 뜻을 가진 단어들 ===");
        DictionaryEntry[] programWords = dictionary.findByMeaning("프로그램");
        for (DictionaryEntry entry : programWords) {
            System.out.println(entry);
        }
    }
}
