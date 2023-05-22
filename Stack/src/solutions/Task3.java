package solutions;

import java.util.Scanner;
import java.util.Stack;

public class Task3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(answer(input));
    }

    public static int answer(String input){
        Stack<Integer> operands = new Stack<>();

        for(int i = 0; i < input.length(); i+=2){
            char current = input.charAt(i);
            if((current == '+') || (current == '-') || (current == '*')){
                int operand1 = operands.pop();
                int operand2 = operands.pop();

                switch (current) {
                    case '+' -> operands.push(operand2 + operand1);
                    case '-' -> operands.push(operand2 - operand1);
                    case '*' -> operands.push(operand2 * operand1);
                }
            } else
                operands.push(Character.digit(current, 10));
        }
        return operands.pop();
    }
}