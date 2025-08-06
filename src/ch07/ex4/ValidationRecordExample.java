package ch07.ex4;

public class ValidationRecordExample {
    record Email(String address) {
        public Email {
            if (address == null || address.isBlank())
                throw new IllegalArgumentException("이메일 주소는 비어있을 수 없습니다");
            if (!address.contains("@"))
                throw new IllegalArgumentException("올바른 이메일 형식이 아닙니다");
        }
        public String domain() {
            return address.substring(address.indexOf("@") + 1);
        }
    }

    record Age(int value) {
        public Age {
            if (value < 0) throw new IllegalArgumentException("나이는 음수일 수 없습니다");
            if (value > 150) throw new IllegalArgumentException("나이가 너무 큽니다");
        }
        public String ageGroup() {
            if (value < 20) return "미성년";
            if (value < 30) return "20대";
            if (value < 40) return "30대";
            if (value < 50) return "40대";
            if (value < 60) return "50대";
            return "60대 이상";
        }
    }

    public static void main(String[] args) {
        try {
            Email email1 = new Email("user@example.com");
            System.out.println("이메일: " + email1);
            System.out.println("도메인: " + email1.domain());

            Age age1 = new Age(25);
            System.out.println("나이: " + age1.value() + " (" + age1.ageGroup() + ")");
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}