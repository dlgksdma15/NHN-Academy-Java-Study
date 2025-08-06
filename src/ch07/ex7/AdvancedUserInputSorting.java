package ch07.ex7;

import java.util.*;
import java.io.*;

public class AdvancedUserInputSorting {

    private static final int MAX_NUMBERS = 100;

    /**
     * 다양한 정렬 알고리즘
     */
    public static void bubbleSort(double[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (array[j] < pivot) {
                i++;
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        double temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return (i + 1);
    }

    /**
     * 파일에서 숫자 읽기
     */
    public static List<Double> readNumbersFromFile(String filename) {
        List<Double> numbers = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(filename))) {
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextDouble()) {
                    double num = fileScanner.nextDouble();
                    if (num > 0) {
                        numbers.add(num);
                    }
                } else {
                    fileScanner.next(); // 숫자가 아닌 토큰 건너뛰기
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + filename);
        }

        return numbers;
    }

    /**
     * 결과를 파일에 저장
     */
    public static void saveResultsToFile(double[] array, String filename,
                                         String sortMethod, double executionTime) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("=== 정렬 결과 ===");
            writer.println("정렬 방법: " + sortMethod);
            writer.printf("실행 시간: %.3f ms\n", executionTime);
            writer.println("총 개수: " + array.length);
            writer.println();

            writer.println("정렬된 숫자들:");
            for (int i = 0; i < array.length; i++) {
                writer.printf("%.2f", array[i]);
                if ((i + 1) % 10 == 0) {
                    writer.println();
                } else if (i < array.length - 1) {
                    writer.print(", ");
                }
            }

            if (array.length % 10 != 0) {
                writer.println();
            }

            writer.println("\n=== 통계 정보 ===");
            writeStatistics(writer, array);

            System.out.println("결과가 " + filename + " 파일에 저장되었습니다.");

        } catch (IOException e) {
            System.out.println("파일 저장 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    private static void writeStatistics(PrintWriter writer, double[] array) {
        if (array.length == 0) return;

        double min = array[0];
        double max = array[array.length - 1];
        double sum = Arrays.stream(array).sum();
        double average = sum / array.length;

        double median;
        if (array.length % 2 == 0) {
            median = (array[array.length/2 - 1] + array[array.length/2]) / 2.0;
        } else {
            median = array[array.length/2];
        }

        writer.printf("최솟값: %.2f\n", min);
        writer.printf("최댓값: %.2f\n", max);
        writer.printf("합계:   %.2f\n", sum);
        writer.printf("평균:   %.2f\n", average);
        writer.printf("중앙값: %.2f\n", median);
        writer.printf("범위:   %.2f\n", max - min);
    }

    /**
     * 메뉴 기반 사용자 인터페이스
     */
    public static void displayMenu() {
        System.out.println("\n=== 고급 정렬 프로그램 ===");
        System.out.println("1. 콘솔에서 숫자 입력");
        System.out.println("2. 파일에서 숫자 읽기");
        System.out.println("3. 랜덤 숫자 생성");
        System.out.println("4. 정렬 방법 선택");
        System.out.println("5. 정렬 실행");
        System.out.println("6. 결과를 파일로 저장");
        System.out.println("7. 성능 비교");
        System.out.println("0. 종료");
        System.out.print("선택: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numberList = new ArrayList<>();
        String sortMethod = "삽입 정렬";
        int sortChoice = 1;

        while (true) {
            displayMenu();

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        inputNumbersFromConsole(scanner, numberList);
                        break;

                    case 2:
                        System.out.print("파일명을 입력하세요: ");
                        String filename = scanner.next();
                        List<Double> fileNumbers = readNumbersFromFile(filename);
                        numberList.addAll(fileNumbers);
                        System.out.println(fileNumbers.size() + "개의 숫자를 읽었습니다.");
                        break;

                    case 3:
                        generateRandomNumbers(scanner, numberList);
                        break;

                    case 4:
                        sortChoice = selectSortingMethod(scanner);
                        sortMethod = getSortMethodName(sortChoice);
                        break;

                    case 5:
                        if (numberList.isEmpty()) {
                            System.out.println("먼저 숫자를 입력하세요.");
                        } else {
                            performSorting(numberList, sortChoice, sortMethod);
                        }
                        break;

                    case 6:
                        if (numberList.isEmpty()) {
                            System.out.println("정렬할 데이터가 없습니다.");
                        } else {
                            System.out.print("저장할 파일명: ");
                            String saveFile = scanner.next();
                            double[] array = numberList.stream().mapToDouble(d -> d).toArray();
                            saveResultsToFile(array, saveFile, sortMethod, 0);
                        }
                        break;

                    case 7:
                        if (numberList.isEmpty()) {
                            System.out.println("비교할 데이터가 없습니다.");
                        } else {
                            performanceComparison(numberList);
                        }
                        break;

                    case 0:
                        System.out.println("프로그램을 종료합니다.");
                        scanner.close();
                        return;

                    default:
                        System.out.println("잘못된 선택입니다.");
                }

            } catch (Exception e) {
                System.out.println("입력 오류: " + e.getMessage());
                scanner.nextLine(); // 버퍼 클리어
            }
        }
    }

    private static void inputNumbersFromConsole(Scanner scanner, List<Double> numberList) {
        System.out.println("양의 실수를 입력하세요 (0을 입력하면 종료):");

        while (numberList.size() < MAX_NUMBERS) {
            System.out.printf("숫자 %d: ", numberList.size() + 1);

            try {
                double input = scanner.nextDouble();

                if (input == 0) {
                    break;
                }

                if (input > 0) {
                    numberList.add(input);
                } else {
                    System.out.println("양수만 입력해주세요.");
                }

            } catch (Exception e) {
                System.out.println("올바른 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }

        System.out.println(numberList.size() + "개의 숫자가 입력되었습니다.");
    }

    private static void generateRandomNumbers(Scanner scanner, List<Double> numberList) {
        System.out.print("생성할 랜덤 숫자 개수: ");
        int count = scanner.nextInt();

        System.out.print("최댓값: ");
        double maxValue = scanner.nextDouble();

        Random random = new Random();
        numberList.clear();

        for (int i = 0; i < Math.min(count, MAX_NUMBERS); i++) {
            double randomNum = random.nextDouble() * maxValue;
            numberList.add(randomNum);
        }

        System.out.println(numberList.size() + "개의 랜덤 숫자가 생성되었습니다.");
    }

    private static int selectSortingMethod(Scanner scanner) {
        System.out.println("\n정렬 방법을 선택하세요:");
        System.out.println("1. 삽입 정렬");
        System.out.println("2. 선택 정렬");
        System.out.println("3. 버블 정렬");
        System.out.println("4. 퀵 정렬");
        System.out.print("선택: ");

        int choice = scanner.nextInt();
        return (choice >= 1 && choice <= 4) ? choice : 1;
    }

    private static String getSortMethodName(int choice) {
        switch (choice) {
            case 1: return "삽입 정렬";
            case 2: return "선택 정렬";
            case 3: return "버블 정렬";
            case 4: return "퀵 정렬";
            default: return "삽입 정렬";
        }
    }

    private static void performSorting(List<Double> numberList, int sortChoice, String sortMethod) {
        double[] array = numberList.stream().mapToDouble(d -> d).toArray();

        System.out.println("\n" + sortMethod + "을(를) 수행합니다...");

        long startTime = System.nanoTime();

        switch (sortChoice) {
            case 1:
                UserInputSorting.insertionSort(array);
                break;
            case 2:
                UserInputSorting.selectionSort(array);
                break;
            case 3:
                bubbleSort(array);
                break;
            case 4:
                quickSort(array, 0, array.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1_000_000.0;

        System.out.println("정렬 완료!");
        System.out.printf("실행 시간: %.3f ms\n", executionTime);

        // 정렬된 결과로 리스트 업데이트
        numberList.clear();
        for (double num : array) {
            numberList.add(num);
        }

        UserInputSorting.printArray(array, "정렬 결과");
    }

    private static void performanceComparison(List<Double> numberList) {
        System.out.println("\n=== 성능 비교 ===");

        double[] originalArray = numberList.stream().mapToDouble(d -> d).toArray();
        String[] methods = {"삽입 정렬", "선택 정렬", "버블 정렬", "퀵 정렬"};

        System.out.printf("%-10s %10s\n", "정렬 방법", "실행시간(ms)");
        System.out.println("-".repeat(25));

        for (int i = 0; i < 4; i++) {
            double[] array = originalArray.clone();

            long startTime = System.nanoTime();

            switch (i) {
                case 0:
                    UserInputSorting.insertionSort(array);
                    break;
                case 1:
                    UserInputSorting.selectionSort(array);
                    break;
                case 2:
                    bubbleSort(array);
                    break;
                case 3:
                    quickSort(array, 0, array.length - 1);
                    break;
            }

            long endTime = System.nanoTime();
            double executionTime = (endTime - startTime) / 1_000_000.0;

            System.out.printf("%-10s %10.3f\n", methods[i], executionTime);
        }
    }
}