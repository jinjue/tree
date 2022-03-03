package alg;

import DataStru.MyArray;

import java.util.Arrays;
import java.util.Stack;

//最小栈问题
public class MinStack {
    private Stack<Integer> mystack = new Stack<Integer>();
    private Stack<Integer> minstack = new Stack<Integer>();

    //入栈
    public void push(int element){
        mystack.push(element);
        if(minstack.empty()||element<=minstack.peek()){
            minstack.push(element);
        }
    }

    //出栈
    public Integer pop(){
        if(mystack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        return mystack.pop();
    }

    public int getMin() throws Exception{
        if(mystack.empty()){
            throw new Exception("栈为空");
        }
        return minstack.peek();
    }


    public static void main(String[] args) throws Exception{
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(10);
        stack.push(3);
        stack.push(7);
        stack.push(8);
        stack.push(2);
        System.out.println("栈的最小值为："+stack.getMin());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("栈的最小值为："+stack.getMin());


    }
}
