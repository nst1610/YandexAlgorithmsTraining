package solutions;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfPeople = Integer.parseInt(scanner.nextLine());

        int[][] table = new int[countOfPeople + 3][3];
        for (int i = 0; i < 3; i++){
            table[i][0] = table[i][1] = table[i][2] = 10801;
        }

        for (int i = 3; i < table.length; i++){
            String[] currentPeople = scanner.nextLine().split(" ");
            table[i][0] = Integer.parseInt(currentPeople[0]);
            table[i][1] = Integer.parseInt(currentPeople[1]);
            table[i][2] = Integer.parseInt(currentPeople[2]);
        }

        System.out.println(minTime(table));
        scanner.close();
    }

    public static int minTime(int[][] table){
        int[] dp = new int[table.length];
        for(int i = 3; i < table.length; i++){
            dp[i] = dp[i - 1] + table[i][0];

            if(dp[i - 2] + table[i - 1][1] < dp[i])
                dp[i] = dp[i - 2] + table[i - 1][1];

            if(dp[i - 3] + table[i - 2][2] < dp[i])
                dp[i] = dp[i - 3] + table[i - 2][2];
        }

        return dp[table.length - 1];
    }
}
