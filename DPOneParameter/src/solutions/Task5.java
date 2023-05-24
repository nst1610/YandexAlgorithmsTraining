package solutions;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] positions  = new int[count];

        for (int i = 0; i < positions.length; i++)
            positions[i] = scanner.nextInt();

        System.out.println(minLength(positions));
    }
    public static int minLength(int[] positions){
        Arrays.sort(positions);

        int[] dp = new int[positions.length];
        dp[1] = positions[1] - positions[0];
        if(positions.length > 2)
            dp[2] = positions[2] - positions[0];

        for (int i = 3; i < positions.length; i++){
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + positions[i] - positions[i -1];
        }

        return dp[dp.length - 1];
    }
}
