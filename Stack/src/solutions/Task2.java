package solutions;
import java.util.Scanner;
import java.util.Stack;

public class Task2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println(isCorrect(input));
    }

    public static String isCorrect(String input){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);

            if((current == '(') || (current == '[') || (current == '{')){
                stack.push(current);
            } else {
                if(stack.empty())
                    return "no";

                switch (current) {
                    case ')':
                        if (stack.pop() != '(')
                            return "no";
                        break;
                    case ']':
                        if (stack.pop() != '[')
                            return "no";
                        break;
                    case '}':
                        if (stack.pop() != '{')
                            return "no";
                        break;
                }
            }
        }
        return stack.empty() ? "yes" : "no";
    }
}