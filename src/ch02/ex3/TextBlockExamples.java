package ch02.ex3;

public class TextBlockExamples {
    public static void main(String[] args) {
        String html = """
                HTML 템플릿:
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Welcome</title>
                </head>
                <body>
                    <h1>Hello, World!</h1>
                    <p>This is a text block example.</p>
                </body>
                </html>
                
                SQL 쿼리:
                SELECT u.name, u.email, o.order_date, o.total
                FROM users u
                JOIN orders o ON u.id = o.user_id
                WHERE o.status = 'completed'
                    AND o.order_date >= '2024-01-01'
                ORDER BY o.order_date DESC
                
                프로그램 도움말:
                사용법: java Calculator [옵션] <숫자1> <연산자> <숫자2>
                
                옵션:
                    -h, --help     도움말 표시
                    -v, --verbose  자세한 정보 표시
                
                연산자:
                    +  덧셈
                    -  뺄셈
                    *  곱셈
                    /  나눗셈
                
                예시:
                    java Calculator 10 + 20
                    java Calculator -v 100 / 3
                """;
        System.out.println(html);
    }
}