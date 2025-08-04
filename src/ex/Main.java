package ex;


public class Main {
    public static int s = 10;

    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        int result1 = a + b + Main.s;
        System.out.println(result1);

        Counter sub = new Counter();
        twice(sub);
        int result = sub.get();
        System.out.println(result);

    }
    public static void twice(Counter c){
        c.plus(10);
        c.plus(20);
    }
}
class Counter {
    public int state = 50;
    public final int count = 20;
    public int get(){
        return state + count;
    }
    public void plus(int n){
        state += n;
    }
}