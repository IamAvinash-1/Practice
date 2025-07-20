package stacck;
import java.util.*;
public class ValidParantheses {
    public static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            // opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            // closing brackets
            } else {
                if(stack.isEmpty()) {return false;}
                if((stack.peek() == '(' && c == ')')  ||
                (stack.peek() == '{' && c == '}')     ||
                (stack.peek() == '[' && c == ']')) {
                    stack.pop();
                } else { return false; }      
            }
        }
        if(stack.empty()) { return true; }
        else { return false; }
    }
    public static void main(String[] args) {
        String str1 = "({[}])";
        // String str2 = "({[}])";
        System.out.println(isValid(str1));
    }
}

