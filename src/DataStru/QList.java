package DataStru;

import pojo.mylist;

//用链表实现队列
public class QList {
    private mylist head;
    private mylist last;
    private int Qlength=0;



    //入队
    public void enterQ(int element) throws Exception{
        mylist myQueue = new mylist(element);
        if(Qlength == 0){//队列为空
            head = myQueue;
            last = myQueue;
        }
        else {
            myQueue.next = head;
            head.pre = myQueue;
            head = myQueue;
        }
        Qlength++;
    }

    //出队
    public void outQ() throws Exception{
        mylist myQueue = last;
        System.out.println("元素："+myQueue.data+"出队");
        last = last.pre;
        if(last!=null){
            last.next=null;
        }

        Qlength--;
    }

    //输出队列
    public void outputQ(){
        mylist begin = last;
        while (begin!=null){
            System.out.print(begin.data+" ");
            begin = begin.pre;
        }
    }

    public static void main(String[] args) throws Exception{
        QList queue_list = new QList();

        for(int i=0;i<9;i++){
            queue_list.enterQ(i);
        }

        System.out.print("队列元素为：");
        queue_list.outputQ();
        System.out.println();
        for(int i=0;i<9;i++){
            queue_list.outQ();
        }

    }

}
