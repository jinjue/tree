package alg;

import java.util.Stack;

//用栈实现队列的入队出队
public class StackQueue {

    private Stack<Integer> stackA= new Stack<Integer>();
    private Stack<Integer> stackB= new Stack<Integer>();

    //入队
    public void enterqueue(int element){
        stackA.push(element);
    }
    //出队
    public Integer outqueue(){
        if(stackB.isEmpty()){
            if(stackA.isEmpty()){
                return null;
            }
            transfer();
        }
        return stackB.pop();
    }

    //栈A元素压入栈B中
    public void transfer(){
        while(!stackA.isEmpty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) throws Exception{
        StackQueue stackQueue = new StackQueue();
        stackQueue.enterqueue(1);
        stackQueue.enterqueue(2);
        stackQueue.enterqueue(3);
        System.out.println(stackQueue.outqueue());
        stackQueue.enterqueue(4);
        System.out.println(stackQueue.outqueue());
        System.out.println(stackQueue.outqueue());
        System.out.println(stackQueue.outqueue());

    }

}
