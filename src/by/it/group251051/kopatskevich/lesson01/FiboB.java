package by.it.group251051.kopatskevich.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {
    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        if (n <= 0) {
            return BigInteger.ZERO;
        }

        BigInteger[] stack = new BigInteger[n + 1];
        stack[0] = BigInteger.ZERO;
        stack[1] = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            stack[i] = stack[i - 1].add(stack[i - 2]);
        }

        return stack[n];
    }
}