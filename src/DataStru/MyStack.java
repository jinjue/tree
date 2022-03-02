package DataStru;

import pojo.mylist;

//用链表实现栈
public class MyStack {
    private mylist head;
    private mylist last;
    private int Qlength=0;



    //入栈
    public void enterS(int element) throws Exception{
        mylist myQueue = new mylist(element);
        if(Qlength == 0){//队列为空
            head = myQueue;
            last = myQueue;
        }
        else {
            last.next = myQueue;
            myQueue.pre = last;
            last = myQueue;
        }
        Qlength++;
    }

    //出栈
    public void outS() throws Exception{
        mylist myQueue = last;
        System.out.println("元素："+myQueue.data+"出栈");
        last = last.pre;
        if(last!=null){
            last.next=null;
        }

        Qlength--;
    }

    //输出栈
    public void outputS(){
        mylist begin = head;
        while (begin!=null){
            System.out.print(begin.data+" ");
            begin = begin.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyStack myStack = new MyStack();

        for(int i=0;i<9;i++){
            myStack.enterS(i);
        }

        System.out.print("栈元素为：");
        myStack.outputS();
        System.out.println();
        for(int i=0;i<9;i++){
            myStack.outS();
        }

    }

}
