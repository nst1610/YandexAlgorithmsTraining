package solutions;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        System.out.println(countOfSeq(N));
    }

    public static int countOfSeq(int N){
        if(N == 1)
            return 2;
        if(N == 2)
            return 4;
        if(N == 3)
            return 7;

        int[] dp = new int[N];
        dp[0] = 2;
        dp[1] = 4;
        dp[2] = 7;

        for (int i = 3; i < N; i ++){
            dp[i] = dp[i - 1] + dp[i  - 2] + dp[i - 3];
        }
        return dp[N - 1];
    }
}
