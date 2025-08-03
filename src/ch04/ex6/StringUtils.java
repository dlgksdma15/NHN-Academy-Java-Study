package ch04.ex6;

// TODO 41: StringUtils 클래스에 상세한 Javadoc 주석 작성하기
/**
 * <p>
 * <h2>주요 기능</h2>
 * <ol>
 *   <li></li>
 *   <li></li>
 *   <li></li>
 * </ol>
 *
 * <p><strong>참고:</strong>
 *
 * @since
 */
public class StringUtils {

    // TODO 42: reverse 메서드에 예제가 포함된 Javadoc 주석 작성하기
    /**
     * <p>예제:
     * <blockquote>
     * <pre>
     * </pre>
     * </blockquote>
     *
     * @param str
     * @return
     */
    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // TODO 43: isPalindrome 메서드에 Javadoc 주석 작성하기
    /**
     * <p>
     * <br>
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverse(cleaned);
        return cleaned.equals(reversed);
    }
}