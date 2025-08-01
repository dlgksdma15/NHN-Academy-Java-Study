package ch03.ex8;

import java.util.Random;

public class LottoNumberGeneratorExample {
    public static void main(String[] args) {
        System.out.println("=== 로또 번호 생성기 ===");

        // 5세트의 로또 번호 생성
        for (int set = 1; set <= 5; set++) {
            int[] lottoNumbers = generateLottoNumbers();

            System.out.print("세트 " + set + ": ");
            for (int i = 0; i < lottoNumbers.length; i++) {
                System.out.printf("%2d ", lottoNumbers[i]);
            }
            System.out.println();
        }
    }

    public static int[] generateLottoNumbers() {
        boolean[] used = new boolean[46];  // 1~45 번호 사용 여부 (인덱스 0은 미사용)
        int[] numbers = new int[6];       // 선택된 6개 번호

        Random random = new Random();

        // TODO: 6개의 서로 다른 번호 선택
        // 힌트: do-while 루프와 중복 검사
        int i = 0;
        // 여기에 코드를 작성하세요
        do{
            int num = random.nextInt(45) + 1;
            numbers[i] = num;
            if(!used[num]){
                numbers[i] = num;
                used[num] = true;
                i++;
            }

        } while(i < 6);


        // TODO: 번호 정렬 (버블 정렬)
        // 힌트: 이중 루프와 교환

        // 버블 정렬 (오름차순)
        for (int pass = 0; pass < numbers.length - 1; pass++) {
            for (int j = 0; j < numbers.length - 1 - pass; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }

        return numbers;
    }
}