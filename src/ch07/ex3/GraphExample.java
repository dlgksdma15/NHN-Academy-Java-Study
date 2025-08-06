package ch07.ex3;
import java.util.ArrayList;

public class GraphExample {

    // 그래프를 나타내는 클래스
    static class Graph {
        private final int V; // 정점의 개수
        private final ArrayList<ArrayList<Integer>> adj; // 인접 리스트

        // 생성자
        Graph(int v) {
            V = v;
            adj = new ArrayList<>(v);
            for (int i = 0; i < v; ++i) {
                adj.add(new ArrayList<>());
            }
        }

        // 무방향 간선 추가 (양방향으로 추가)
        void addEdge(int v, int w) {
            adj.get(v).add(w);
            adj.get(w).add(v); // 무방향 그래프이므로 반대 방향도 추가
        }

        // 각 정점의 인접 리스트를 출력하는 메서드
        void printAdjacencyList() {
            for (int i = 0; i < V; i++) {
                System.out.print("정점 " + i + "의 인접 정점: ");
                for (Integer neighbor : adj.get(i)) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }

        // 각 정점의 차수를 출력하는 메서드
        void printDegrees() {
            System.out.println("각 정점의 차수:");
            for (int i = 0; i < V; i++) {
                System.out.println("정점 " + i + ": " + adj.get(i).size());
            }
        }
    }

    public static void main(String[] args) {
        // 5개의 정점을 가진 그래프 생성
        Graph g = new Graph(5);

        // 간선 추가
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        // 인접 리스트 출력
        g.printAdjacencyList();

        // 각 정점의 차수 출력
        g.printDegrees();
    }
}