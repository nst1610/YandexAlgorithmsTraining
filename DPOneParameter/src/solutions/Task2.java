package solutions;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(countOfWays(N, k));
        scanner.close();
    }

    public static int countOfWays(int N, int k){
        int[] board = new int[N];

        if(N == 1)
            return 1;
        if(k == 1)
            return 1;
        if(N == 2)
            return 1;

        board[0] = 1;
        board[1] = 1;
        board[2] = 2;

        for(int i = 3; i < N; i++){
            if(i <= k)
                board[i] = 2 * board[i - 1];

            else
                board[i] = 2 * board[i - 1] - board[i - k - 1];
        }
        return board[N - 1];
    }
}
