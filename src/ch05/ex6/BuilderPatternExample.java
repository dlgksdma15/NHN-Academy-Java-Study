package ch05.ex6;

/**
 * 빌더 패턴을 사용한 복잡한 객체 생성
 */
class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean onions;

    // private 생성자 - 빌더를 통해서만 생성 가능
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.onions = builder.onions;
    }

    // 정적 내부 빌더 클래스
    public static class Builder {
        private String size;
        private boolean cheese = true;   // 기본값: 치즈 있음
        private boolean pepperoni = false;
        private boolean mushrooms = false;
        private boolean onions = false;

        public Builder(String size) {
            this.size = size;
        }

        public Builder cheese(boolean value) {
            this.cheese = value;
            return this;
        }

        public Builder pepperoni(boolean value) {
            this.pepperoni = value;
            return this;
        }

        public Builder mushrooms(boolean value) {
            this.mushrooms = value;
            return this;
        }

        public Builder onions(boolean value) {
            this.onions = value;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" 피자");
        boolean hasTopping = false;

        if (cheese) {
            sb.append(" + 치즈");
            hasTopping = true;
        }
        if (pepperoni) {
            sb.append(" + 페퍼로니");
            hasTopping = true;
        }
        if (mushrooms) {
            sb.append(" + 버섯");
            hasTopping = true;
        }
        if (onions) {
            sb.append(" + 양파");
            hasTopping = true;
        }

        if (!hasTopping) {
            sb.append(" (토핑 없음)");
        }

        return sb.toString();
    }
}

// 테스트 클래스
public class BuilderPatternExample {
    public static void main(String[] args) {
        // pizza1: Large, 치즈 + 페퍼로니 + 버섯
        Pizza pizza1 = new Pizza.Builder("Large")
                .pepperoni(true)
                .mushrooms(true)
                .build();

        // pizza2: Medium, 치즈 없음 + 양파
        Pizza pizza2 = new Pizza.Builder("Medium")
                .cheese(false)
                .onions(true)
                .build();

        // pizza3: Small, 기본 설정 (치즈만)
        Pizza pizza3 = new Pizza.Builder("Small").build();

        System.out.println("주문한 피자:");
        System.out.println("1. " + pizza1);
        System.out.println("2. " + pizza2);
        System.out.println("3. " + pizza3);
    }
}
