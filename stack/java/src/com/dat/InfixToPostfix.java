package com.dat;

public class InfixToPostfix {
    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    static int getOperatorPriority(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public static String solve(String expression) {
        String res = "";
        java.util.Stack<Character> s = new java.util.Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                res += c;
            } else if (c == '(') {
                s.push(c);
            } else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    res += s.pop();
                }
                s.pop();
            } else {
                while (!s.isEmpty() && getOperatorPriority(c) <= getOperatorPriority(s.peek())) {
                    res += s.pop();
                }
                s.push(c);
            }
        }
        while (!s.isEmpty()) {
            res += s.pop();
        }
        return res;
    }

    // Driver method
    public static void main(String[] args) {
        String exp = "A*B-(C+D)+E";
        System.out.println(solve(exp));
    }
}
