package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        calculate(N);
    }

    public static void calculate(int N) {
        int[] dp = new int[N + 1];
        int[] prev = new int[N + 1];
        dp[1] = 0;
        prev[1] = -1;
        if(N > 1) {
            dp[2] = 1;
            prev[2] = 1;
            if(N > 2) {
                dp[3] = 1;
                prev[3] = 1;
            }
        }

        for (int i = 4; i <= N; i++){
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;
            if((i % 3 == 0) && (dp[ i / 3] < dp [i])){
                prev[i] = i / 3;
                dp[i] = dp[i / 3] + 1;
            }
            if((i % 2 == 0) && (dp[i / 2] < dp[i])){
                prev[i] = i / 2;
                dp[i] = dp[i / 2] + 1;
            }
        }
        System.out.println(dp[N]);

        ArrayList<Integer> answer = new ArrayList<>();
        while (N > 0){
            answer.add(N);
            N = prev[N];
        }

        for(int i = answer.size() - 1; i > 0; i--)
            System.out.print(answer.get(i) + " ");
        System.out.print(answer.get(0));
    }
}