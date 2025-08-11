package ch10.ex5;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class GenericCache<K, V> {
    private final Map<K, CacheEntry<V>> cache;
    private final int maxSize;
    private final long ttlMillis; // Time To Live

    private static class CacheEntry<V> {
        final V value;
        final long createdTime;

        CacheEntry(V value) {
            this.value = value;
            this.createdTime = System.currentTimeMillis();
        }

        boolean isExpired(long ttlMillis) {
            return ttlMillis > 0 &&
                    (System.currentTimeMillis() - createdTime) > ttlMillis;
        }
    }

    public GenericCache(int maxSize) {
        this(maxSize, -1); // TTL 없음
    }

    public GenericCache(int maxSize, long ttlMillis) {
        this.cache = new ConcurrentHashMap<>();
        this.maxSize = maxSize;
        this.ttlMillis = ttlMillis;
    }

    public void put(K key, V value) {
        // TODO 13: key가 null이면 IllegalArgumentException 던지기
        if (key == null) {
            throw new IllegalArgumentException("Key는 null일 수 없습니다.");
        }

        // TODO 14: 캐시가 최대 크기에 도달했으면 evictOldest() 호출
        if (maxSize > 0 && cache.size() >= maxSize) {
            evictOldest();
        }

        // TODO 15: 새 CacheEntry를 생성하여 cache에 저장
        cache.put(key, new CacheEntry<>(value));
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        // TODO 16: cache에서 key에 해당하는 entry 가져오기
        CacheEntry<V> entry = cache.get(key);
        // TODO 17: entry가 null이면 null 반환
        if (entry == null) {
            return null;
        }

        // TODO 18: entry가 만료되었는지 확인 (isExpired 메서드 사용)
        if (entry.isExpired(ttlMillis)) {
            // TODO 19: 만료되었으면 cache에서 제거하고 null 반환
            cache.remove(key);
            return null;
        }

        // TODO 20: entry의 value 반환
        return entry.value;
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public V remove(K key) {
        CacheEntry<V> entry = cache.remove(key);
        return entry != null ? entry.value : null;
    }

    public void clear() {
        cache.clear();
    }

    public int size() {
        cleanupExpired();
        return cache.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // 만료된 항목 정리
    private void cleanupExpired() {
        if (ttlMillis <= 0) return;

        cache.entrySet().removeIf(entry ->
                entry.getValue().isExpired(ttlMillis));
    }

    // 가장 오래된 항목 제거 (LRU 대신 단순 구현)
    private void evictOldest() {
        if (cache.isEmpty()) return;

        // TODO 21: 가장 오래된 키와 시간을 추적할 변수 초기화
        Object oldestKey = null;
        long oldestTime = Long.MAX_VALUE;

        // TODO 22: cache의 모든 entry를 순회하며
        for (Map.Entry<K, CacheEntry<V>> entry : cache.entrySet()) {
            // - createdTime이 더 작은 (더 오래된) entry 찾기
            if (entry.getValue().createdTime < oldestTime) {
                // - 찾으면 oldestKey와 oldestTime 업데이트
                oldestTime = entry.getValue().createdTime;
                oldestKey = entry.getKey();
            }
        }

        // TODO 23: oldestKey가 null이 아니면 cache에서 제거
        if (oldestKey != null) {
            cache.remove(oldestKey);
        }
    }

    // 통계 정보
    public void printStats() {
        cleanupExpired();
        System.out.println("캐시 통계:");
        System.out.println("  현재 크기: " + cache.size());
        System.out.println("  최대 크기: " + maxSize);
        System.out.println("  TTL: " + (ttlMillis > 0 ? ttlMillis + "ms" : "무제한"));
    }

    public static void main(String[] args) throws InterruptedException {
        // 기본 캐시 테스트
        GenericCache<String, Integer> cache = new GenericCache<>(3);

        cache.put("one", 1);
        cache.put("two", 2);
        cache.put("three", 3);

        System.out.println("캐시 값들:");
        System.out.println("one: " + cache.get("one"));
        System.out.println("two: " + cache.get("two"));
        System.out.println("three: " + cache.get("three"));

        // 크기 초과 테스트
        cache.put("four", 4); // 가장 오래된 항목 제거됨
        System.out.println("\n크기 초과 후:");
        System.out.println("one: " + cache.get("one")); // null일 수 있음
        System.out.println("four: " + cache.get("four"));

        cache.printStats();

        // TTL 테스트
        System.out.println("\n=== TTL 테스트 ===");
        GenericCache<String, String> ttlCache = new GenericCache<>(5, 1000); // 1초 TTL

        ttlCache.put("temp", "임시 데이터");
        System.out.println("즉시 조회: " + ttlCache.get("temp"));

        Thread.sleep(1100); // 1.1초 대기

        System.out.println("1.1초 후 조회: " + ttlCache.get("temp")); // null
        ttlCache.printStats();
    }
}