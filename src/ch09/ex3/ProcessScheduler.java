package ch09.ex3;

import java.util.Random;

public class ProcessScheduler {

    static class Process {
        int id;
        String name;
        int cpuTime;      // 필요한 CPU 시간
        int remainingTime; // 남은 CPU 시간
        int waitingTime;  // 대기 시간
        int turnaroundTime; // 총 소요 시간

        public Process(int id, String name, int cpuTime) {
            this.id = id;
            this.name = name;
            this.cpuTime = cpuTime;
            this.remainingTime = cpuTime;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
        }

        @Override
        public String toString() {
            return String.format("P%d(%s)", id, name);
        }
    }

    /**
     * FCFS (First Come First Served) 스케줄링
     */
    static class FCFSScheduler {
        private LinkedQueue<Process> readyQueue;
        private int currentTime;

        public FCFSScheduler() {
            this.readyQueue = new LinkedQueue<>();
            this.currentTime = 0;
        }

        public void addProcess(Process process) {
            readyQueue.enqueue(process);
            System.out.println("시간 " + currentTime + ": " + process + " 도착");
        }

        public void run() {
            System.out.println("\n=== FCFS 스케줄링 시작 ===");

            while (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.dequeue();

                // 대기 시간 = 현재 시간 - 도착 시간(0으로 가정)
                currentProcess.waitingTime = currentTime;

                System.out.println("시간 " + currentTime + ": " + currentProcess +
                        " 실행 시작 (CPU 시간: " + currentProcess.cpuTime + ")");

                // 프로세스 실행
                currentTime += currentProcess.cpuTime;

                // 총 소요 시간 = 대기 시간 + CPU 시간
                currentProcess.turnaroundTime = currentProcess.waitingTime + currentProcess.cpuTime;

                System.out.println("시간 " + currentTime + ": " + currentProcess +
                        " 완료 (대기: " + currentProcess.waitingTime +
                        ", 총소요: " + currentProcess.turnaroundTime + ")");
            }

            System.out.println("=== 스케줄링 완료 ===\n");
        }
    }

    /**
     * Round Robin 스케줄링
     */
    static class RoundRobinScheduler {
        private LinkedQueue<Process> readyQueue;
        private int timeQuantum;
        private int currentTime;

        public RoundRobinScheduler(int timeQuantum) {
            this.readyQueue = new LinkedQueue<>();
            this.timeQuantum = timeQuantum;
            this.currentTime = 0;
        }

        public void addProcess(Process process) {
            readyQueue.enqueue(process);
            System.out.println("시간 " + currentTime + ": " + process + " 도착");
        }

        public void run() {
            System.out.println("\n=== Round Robin 스케줄링 시작 (Time Quantum: " +
                    timeQuantum + ") ===");

            while (!readyQueue.isEmpty()) {
                Process currentProcess = readyQueue.dequeue();

                int executionTime = Math.min(timeQuantum, currentProcess.remainingTime);

                System.out.println("시간 " + currentTime + ": " + currentProcess +
                        " 실행 (남은 시간: " + currentProcess.remainingTime + ")");

                currentTime += executionTime;
                currentProcess.remainingTime -= executionTime;

                if (currentProcess.remainingTime > 0) {
                    // 아직 완료되지 않았으면 다시 큐에 추가
                    readyQueue.enqueue(currentProcess);
                    System.out.println("시간 " + currentTime + ": " + currentProcess +
                            " 중단 (남은 시간: " + currentProcess.remainingTime + ")");
                } else {
                    // 프로세스 완료
                    currentProcess.turnaroundTime = currentTime;
                    System.out.println("시간 " + currentTime + ": " + currentProcess +
                            " 완료 (총소요: " + currentProcess.turnaroundTime + ")");
                }
            }

            System.out.println("=== 스케줄링 완료 ===\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== 프로세스 스케줄링 시뮬레이터 ===\n");

        // FCFS 스케줄링 테스트
        FCFSScheduler fcfs = new FCFSScheduler();
        fcfs.addProcess(new Process(1, "웹브라우저", 4));
        fcfs.addProcess(new Process(2, "텍스트에디터", 2));
        fcfs.addProcess(new Process(3, "컴파일러", 6));
        fcfs.addProcess(new Process(4, "음악플레이어", 3));
        fcfs.run();

        // Round Robin 스케줄링 테스트
        RoundRobinScheduler rr = new RoundRobinScheduler(2);
        rr.addProcess(new Process(1, "웹브라우저", 4));
        rr.addProcess(new Process(2, "텍스트에디터", 2));
        rr.addProcess(new Process(3, "컴파일러", 6));
        rr.addProcess(new Process(4, "음악플레이어", 3));
        rr.run();
    }
}