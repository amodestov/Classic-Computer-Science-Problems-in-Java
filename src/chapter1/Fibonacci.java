package chapter1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Fibonacci {

    public static void main(String[] args) {
        int q = 10, w = 5;
        System.out.println(q + ~w + 0b00000001);
    }

    private static int fib1(int n) {
        return fib1(n);
    }

    private static int fib2(int n) {
        if (n < 2) {
            return n;
        }
        return fib2(n - 1) + fib2(n - 2);
    }

    private static Map<Integer, Integer> memo = new HashMap<>(Map.of(0, 0, 1, 1));

    private static int fib3(int n) {
        if (!memo.containsKey(n)) {
            memo.put(n, fib3(n - 1) + fib3(n - 2));
        }
        return memo.get(n);
    }

    private static int fib4(int n) {
        int last = 0, next = 1;
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }

    private static int last = 0, next = 1;

    private static void stream(int n) {
        IntStream.generate(() -> {
            int oldLast = last;
            last = next;
            next = oldLast + next;
            return oldLast;
        }).limit(n).forEachOrdered(System.out::println);
    }
}
