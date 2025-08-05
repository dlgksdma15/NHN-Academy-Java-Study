package ch05.ex6;

/**
 * 메서드 체이닝을 구현하는 StringBuilder 스타일 클래스
 */
class MessageBuilder {
    private StringBuilder message;

    public MessageBuilder() {
        this.message = new StringBuilder();
    }

    public MessageBuilder append(String text) {
        // TODO 7: message에 text를 추가하고 this를 반환하기
        // 메서드 체이닝을 위해 자기 자신을 반환
        message.append(text);
        return this;
    }

    public MessageBuilder appendLine(String text) {
        // TODO 8: message에 text와 줄바꿈 문자를 추가하고 this를 반환하기
        message.append(text).append("\n");
        return this;
    }

    public MessageBuilder appendWithSpace(String text) {
        // TODO 9: message가 비어있지 않으면 공백 추가 후 text 추가하기
        // this를 반환하여 체이닝 가능하게 하기
        if (message.length() > 0) {
            message.append(" ");
        }
        message.append(text);
        return this;
    }

    public MessageBuilder reset() {
        // TODO 10: message를 비우고 this를 반환하기
        message.setLength(0);
        return this;
    }

    @Override
    public String toString() {
        return message.toString();
    }
}

// 테스트
public class ChainingExample {
    public static void main(String[] args) {
        // TODO 11: MessageBuilder 객체 생성하기
        MessageBuilder builder = new MessageBuilder();

        // TODO 12: 메서드 체이닝을 사용하여 문자열 구성하기
        // "안녕하세요 여러분!\n오늘은 좋은 날씨입니다."
        // append(), appendWithSpace(), appendLine() 활용
        String result1 = builder
                .append("안녕하세요")
                .appendWithSpace("여러분!")
                .appendWithSpace("오늘은")
                .appendWithSpace("좋은")
                .appendWithSpace("날씨입니다.")
                .toString();
        // TODO 13: 리셋 후 다시 사용하기
        // "메서드 체이닝은 편리합니다!"
        String result2 = builder
                .reset()
                .append("메서드")
                .appendWithSpace("체이닝은")
                .appendWithSpace("편리합니다!")
                .toString();

        // 한 줄로 출력
        System.out.println(result1 + " " + result2);
    }
}