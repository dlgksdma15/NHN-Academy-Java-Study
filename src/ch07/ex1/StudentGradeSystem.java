package ch07.ex1;

public class StudentGradeSystem {
    // TODO: 가변 인수를 사용한 성적 입력 메서드를 작성하세요
    // 메서드명: inputGrades
    // 매개변수: String studentName, double... scores
    // 학생 이름과 각 과목 점수를 출력하고 배열 반환
    static double[] inputGrades(String studentName,double... scores){
        System.out.println(studentName + "학생의 성적: ");
        for(int i = 0; i < scores.length; i++){
            System.out.println("과목 " + i + ": " + scores[i]);}
        return scores;
    }


    // TODO: 성적 통계 계산 메서드를 작성하세요
    // 메서드명: calculateStats
    // 매개변수: String name, double[] grades
    // for-each 루프로 평균, 최고점, 최저점 계산 및 출력
    static double calculateStats(String name,double[] grades){
        System.out.println("=== " + name +" 성적 분석 ===");
        double max = 0;
        double min = grades[0];
        double total = 0;

        for(int i = 0; i < grades.length;i++){
            if(max < grades[i]){
                max = grades[i];

            }
            if(min > grades[i]){
                min = grades[i];
            }
            total += grades[i];
        }
        System.out.println("평균: " + total/grades.length);
        System.out.println("최고점: " + max);
        System.out.println("최저점: " + min);
        return total/ grades.length;
    }

    // TODO: 우수 학생 선발 메서드를 작성하세요
    // 메서드명: selectHonorStudents
    // 매개변수: String[] names, double[] averages
    // 평균 85점 이상인 학생들을 출력
    static void selectHonorStudents(double[] score,String[] name){
        System.out.println("=== 우수 학생 명단 (평균 85점 이상) ===");
        for(int i = 0; i < name.length; i++){
            if(score[i] > 85.0){
                System.out.printf("%s: %.2f점\n",name[i],score[i]);
            }
        }
    }


    public static void main(String[] args) {
        // 학생 데이터
        String[] students = {"김철수", "이영희", "박민수"};

        // 각 학생의 성적 입력 (가변 인수 사용)
        double[] kimScores = inputGrades("김철수", 85.5, 92.0, 78.5, 88.0, 91.5);
        double[] leeScores = inputGrades("이영희", 95.0, 88.5, 92.0, 87.5, 89.0);
        double[] parkScores = inputGrades("박민수", 78.0, 82.5, 75.0, 80.0, 77.5);

        // 통계 계산
        double kim = calculateStats("김철수", kimScores);
        double lee = calculateStats("이영희", leeScores);
        double park = calculateStats("박민수", parkScores);

        double[] score = {kim,lee,park};
        // 우수 학생 선발
        selectHonorStudents(score,students);
    }

}