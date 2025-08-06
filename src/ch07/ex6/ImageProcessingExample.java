package ch07.ex6;

import java.util.Random;

public class ImageProcessingExample {
    public static void main(String[] args) {
        int width = 8;
        int height = 8;

        // 흑백 이미지 생성 (0-9 값으로 단순화)
        int[][] image = generateRandomImage(width, height);

        System.out.println("원본 이미지:");
        printImage(image);

        // 이미지 반전
        int[][] inverted = invertImage(image);
        System.out.println("\n반전된 이미지:");
        printImage(inverted);

        // 이미지 회전 (90도 시계방향)
        int[][] rotated = rotateImage90(image);
        System.out.println("\n90도 회전된 이미지:");
        printImage(rotated);

        // 이미지 미러링 (좌우 반전)
        int[][] mirrored = mirrorImageHorizontal(image);
        System.out.println("\n좌우 반전된 이미지:");
        printImage(mirrored);

        // 블러 효과 (평균 필터)
        int[][] blurred = applyBlur(image);
        System.out.println("\n블러 효과 적용:");
        printImage(blurred);

        // 히스토그램 출력
        System.out.println("\n=== 원본 이미지 히스토그램 ===");
        printHistogram(image);
    }

    public static int[][] generateRandomImage(int width, int height) {
        int[][] image = new int[height][width];
        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = random.nextInt(10);  // 0-9 범위
            }
        }

        return image;
    }

    public static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    public static int[][] invertImage(int[][] image) {
        int[][] result = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[i][j] = 9 - image[i][j];  // 0-9 범위에서 반전
            }
        }

        return result;
    }

    public static int[][] rotateImage90(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][rows - 1 - i] = image[i][j];
            }
        }

        return result;
    }

    public static int[][] mirrorImageHorizontal(int[][] image) {
        int[][] result = new int[image.length][image[0].length];

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                result[i][image[0].length - 1 - j] = image[i][j];
            }
        }

        return result;
    }

    public static int[][] applyBlur(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;
        int[][] result = new int[rows][cols];

        // 경계는 그대로 유지, 내부만 블러 적용
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                int sum = 0;
                int count = 0;

                // 3x3 영역의 평균 계산
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        sum += image[i + di][j + dj];
                        count++;
                    }
                }

                result[i][j] = sum / count;
            }
        }

        // 경계 복사
        for (int i = 0; i < rows; i++) {
            result[i][0] = image[i][0];
            result[i][cols - 1] = image[i][cols - 1];
        }
        for (int j = 0; j < cols; j++) {
            result[0][j] = image[0][j];
            result[rows - 1][j] = image[rows - 1][j];
        }

        return result;
    }

    public static void printHistogram(int[][] image) {
        int[] histogram = new int[10];  // 0-9 값의 빈도

        // 히스토그램 계산
        for (int[] row : image) {
            for (int pixel : row) {
                histogram[pixel]++;
            }
        }

        // 히스토그램 출력
        for (int i = 0; i < histogram.length; i++) {
            System.out.printf("값 %d: %d개 ", i, histogram[i]);
            for (int j = 0; j < histogram[i]; j++) {
                System.out.print("■");
            }
            System.out.println();
        }
    }
}

