package stack;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res =0;
        for (int i = 0; i <tokens.length;i++){
            int value = validateOprator(tokens[i]);
            if(value !=-1){
                res=caculate(stack.pop(),stack.pop(),value);
                stack.push(res);
                continue;
            }
            stack.push(Integer.parseInt(tokens[i]));
        }

        return stack.pop();
    }
    private int caculate(int num2,int num1,int oprater){
        switch (oprater) {
            case 1:
                return num1+num2;
            case 2:
                return num1-num2;
            case 3:
                return num1*num2;
            case 4:
                return num1/num2;
            default:
                return num2;
        }

    }
    private int validateOprator(String str) {
        switch (str) {
            case "+":
                return 1;
            case "-":
                return 2;
            case "*":
                return 3;
            case "/":
                return 4;
            default:
                return -1;
        }
    }
}
