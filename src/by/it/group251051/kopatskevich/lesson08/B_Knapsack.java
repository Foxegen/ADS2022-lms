package by.it.group251051.kopatskevich.lesson08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Задача на программирование: рюкзак без повторов

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        число золотых слитков
                    (каждый можно использовать только один раз).
Следующая строка содержит n целых чисел, задающих веса каждого из слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.

Sample Input:
10 3
1 4 8
Sample Output:
9

*/

public class B_Knapsack {

    int getMaxWeight(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int W = scanner.nextInt(); // Вместимость рюкзака
        int n = scanner.nextInt(); // Число золотых слитков
        int[] weights = new int[n]; // Веса золотых слитков

        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        int[][] dp = new int[W + 1][n + 1];

        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1];
                if (weights[j - 1] <= i) {
                    int val = dp[i - weights[j - 1]][j - 1] + weights[j - 1];
                    if (dp[i][j] < val) {
                        dp[i][j] = val;
                    }
                }
            }
        }

        return dp[W][n];
    }



    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson08/dataB.txt");
        B_Knapsack instance = new B_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }

}