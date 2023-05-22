package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> commands = new ArrayList<>();

        while (scanner.hasNextLine()){
            String current = scanner.nextLine();
            if(current.equals("exit")){
                commands.add(current);
                break;
            }
            commands.add(current);
        }

        LinkedList<Integer> stack = new LinkedList<>();

        for (String command : commands){
            stack(stack, command);
        }
    }

    public static void stack(LinkedList<Integer> stack, String command){
        switch (command){
            case "pop":
                if(stack.size() == 0)
                    System.out.println("error");
                else
                    System.out.println(stack.removeLast());
                break;
            case "back":
                if(stack.size() == 0) System.out.println("error");
                else System.out.println(stack.peekLast());
                break;
            case "size":
                System.out.println(stack.size());
                break;
            case "clear":
                stack.clear();
                System.out.println("ok");
                break;
            case"exit":
                System.out.println("bye");
                break;
            default:
                stack.add(Integer.valueOf(command.split(" ")[1]));
                System.out.println("ok");
        }
    }
}