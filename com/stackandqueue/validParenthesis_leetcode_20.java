package com.stackandqueue;
import java.util.Stack;
public class validParenthesis_leetcode_20 {

        public boolean isValid(String s) {
            Stack<Character> stack= new Stack<>();
            int length= s.length();
            for (char ch : s.toCharArray()) {
                if(ch=='{' || ch=='(' || ch=='['){
                    stack.push(ch);
                }
                else {
                    if(ch =='}'){
                        if( stack.isEmpty() || stack.pop() != '{'  ){
                            return false;
                        }
                    }
                    if(ch==')'){
                        if(stack.isEmpty() || stack.pop() != '(' ){
                            return false;
                        }
                    }
                    if(ch==']'){
                        if(stack.isEmpty() || stack.pop() != '[' ){
                            return false;
                        }
                    }
                }
            }
            return stack.isEmpty();
        }

    public boolean checkValidString(String s) {
        Stack<Integer> stackParan = new Stack<>();
        Stack<Integer> stackStar = new Stack<>();

        //condition for the input and checking the pop for )
        //we are storing the indices rather than the actual characters because to keep the track of the order in which
        //they are occuring.
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stackParan.push(i);
            }
            else if(ch=='*'){
                stackStar.push(i);
            }
            else{
                if(!stackParan.isEmpty())
                    stackParan.pop();
                else if(!stackStar.isEmpty())
                    stackStar.pop();
                else
                    return false;
            }
        }

        //if there are any ( left then we also have to check if any * is left to make it ) but the condition is that
        // it should be like this (* and not as *( that is for every index of ( there must be * with a index greater
        // than ( in every pop operation remaing for both the stacks otherwise if any index of ( is greater than * index for that
        //pop operation just return false as it means that there is a *( condition

        //basically checking the order

        while(!stackParan.isEmpty() && !stackStar.isEmpty()){
            if(stackParan.pop() > stackStar.pop()){
                return false;
            }
        }

        return stackParan.isEmpty();
    }




}


