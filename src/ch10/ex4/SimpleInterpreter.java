package ch10.ex4;

import java.util.*;
import java.util.regex.*;

public class SimpleInterpreter {
    private Map<String, Double> symbolTable;

    public SimpleInterpreter() {
        symbolTable = new HashMap<>();
        // 기본 상수 정의
        symbolTable.put("pi", Math.PI);
        symbolTable.put("e", Math.E);
    }

    // let 명령 처리: let x = 10
    public void executeLet(String command) {
        Pattern pattern = Pattern.compile("let\\s+(\\w+)\\s*=\\s*(.+)");
        Matcher matcher = pattern.matcher(command);

        if (matcher.matches()) {
            // TODO 1: matcher에서 변수명(group 1) 추출
            String varName = matcher.group(1);
            // TODO 2: matcher에서 표현식(group 2) 추출
            String expression = matcher.group(2);

            try {
                // TODO 3: evaluateExpression으로 표현식 평가
                double value = evaluateExpression(expression);
                // TODO 4: symbolTable에 변수와 값 저장
                symbolTable.put(varName, value);
                // TODO 5: 결과 출력 (형식: "변수명 = 값")
                System.out.printf("%s = %.2f\n", varName, value);

            } catch (Exception e) {
                System.err.println("오류: " + e.getMessage());
            }
        }
    }

    // print 명령 처리: print x + 5
    public void executePrint(String command) {
        // TODO 6: "print " 이후의 표현식 추출 (substring 사용)
        String expression = command.substring("print ".length());

        try {
            // TODO 7: 표현식 평가하여 결과 계산
            double result = evaluateExpression(expression);
            // TODO 8: 계산 결과 출력
            System.out.println(result);

        } catch (Exception e) {
            System.err.println("오류: " + e.getMessage());
        }
    }

    // 간단한 표현식 평가 (변수 치환만)
    private double evaluateExpression(String expression) {
        // 변수를 값으로 치환
        for (Map.Entry<String, Double> entry : symbolTable.entrySet()) {
            String var = entry.getKey();
            Double value = entry.getValue();
            expression = expression.replaceAll("\\b" + var + "\\b",
                    value.toString());
        }

        // 간단한 수식 계산 (실제로는 파서가 필요)
        return evaluateSimpleExpression(expression);
    }

    // 매우 간단한 수식 계산 (예시용)
    private double evaluateSimpleExpression(String expr) {
        // 실제 구현에서는 제대로 된 파서 필요
        // 여기서는 JavaScript 엔진 사용 예시
        try {
            javax.script.ScriptEngineManager manager =
                    new javax.script.ScriptEngineManager();
            javax.script.ScriptEngine engine =
                    manager.getEngineByName("JavaScript");
            return ((Number) engine.eval(expr)).doubleValue();
        } catch (Exception e) {
            throw new RuntimeException("수식 평가 실패: " + expr);
        }
    }

    public static void main(String[] args) {
        SimpleInterpreter interpreter = new SimpleInterpreter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("간단한 인터프리터 (quit로 종료)");
        System.out.println("명령: let 변수 = 값, print 표현식");

        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine().trim();

            if (command.equals("quit")) break;

            if (command.startsWith("let ")) {
                interpreter.executeLet(command);
            } else if (command.startsWith("print ")) {
                interpreter.executePrint(command);
            } else if (command.equals("vars")) {
                // 모든 변수 출력
                System.out.println("정의된 변수:");
                interpreter.symbolTable.forEach((k, v) ->
                        System.out.println("  " + k + " = " + v));
            } else {
                System.out.println("알 수 없는 명령");
            }
        }

        scanner.close();
    }
}