package solutions;

import java.util.Scanner;
import java.util.Stack;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[N];

        for(int i = 0; i < N; i++){
            numbers[i] = scanner.nextInt();
        }

        System.out.println(isPossible(numbers));
    }

    public static String isPossible(int[] numbers){
        Stack<Integer> stack = new Stack<>();
        int current = 1;

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] != current){
                stack.push(numbers[i]);
            } else {
                stack.push(numbers[i]);
                while (!stack.empty() && (current ==stack.peek())){
                    stack.pop();
                    current++;
                }
            }
        }
        return stack.empty() ? "YES" : "NO";
    }
}
