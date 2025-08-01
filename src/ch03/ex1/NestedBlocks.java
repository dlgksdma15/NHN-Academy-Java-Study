package ch03.ex1;

public class NestedBlocks {
    public static void main(String[] args) {
        int level1 = 1;

        {
            int level2 = 2;
            System.out.println("레벨 2: " + level1 + ", " + level2);

            {
                int level3 = 3;
                System.out.println("레벨 3: " + level1 + ", " + level2 + ", " + level3);
            }
            // level3는 여기서 접근 불가
        }
        // level2와 level3는 여기서 접근 불가
    }
}