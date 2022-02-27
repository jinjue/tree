package DataStru;


import pojo.MyQueue;

//双向链表
public class MyList {
    private MyQueue head;
    private MyQueue last;
    private int Qlength=0;

    //插入元素
    public void insertList(int data,int index) throws Exception{
        MyQueue myQueue = new MyQueue(data);
        if(index<0||index>Qlength){
            throw  new Exception("超出链表范围");
        }
        if(Qlength == 0){//队列为空
            head = myQueue;
            last = myQueue;
        }
        else if(index==0){
            System.out.println("链表头插入元素");
            myQueue.next = head;
            head.pre = myQueue;
            head = myQueue;
        }
        else if(Qlength==index){
            System.out.println("链表尾插入元素");
            last.next = myQueue;
            myQueue.pre = last;
            last = myQueue;
        }
        else {
            System.out.println("链表中插入元素");
            MyQueue element = search(index-1);
            myQueue.next = element.next;
            element.next = element;
            myQueue.pre = element;
            myQueue.next.pre = myQueue;
        }
        Qlength++;
    }

    //查找链表元素
    public MyQueue search(int index) throws Exception{
        if(index<0||index>Qlength){
            throw  new Exception("超出链表范围");
        }
        MyQueue element = head;
        for(int i=0;i<index;i++){
            element = element.next;
        }
        return element;
    }

    //删除元素
    public void deleteList(int index) throws Exception{
        if(index<0||index>Qlength){
            throw  new Exception("超出链表范围");
        }
        MyQueue delete = null;
        if(index == 0){
            System.out.println("链表头删除元素");
            delete = head;
            head = head.next;
        }else if(index == Qlength-1){
            System.out.println("链表尾删除元素");
            delete = last;
            last.next=null;
        }
        else {
            System.out.println("链表中删除元素");
            MyQueue element = search(index-1);
            MyQueue myQueue = element.next.next;
            delete = element.next;
            element.next = myQueue;
            myQueue.pre = element;
        }
        Qlength--;
        System.out.println("删除元素："+delete.data);
    }

    //输出链表
    public void output(){
        MyQueue begin = head;
        while (begin!=null){
            System.out.print(begin.data+" ");
            begin = begin.next;
        }
    }

    public static void main(String[] args) throws Exception{
        MyList myList = new MyList();

        for(int i=0;i<3;i++){
            myList.insertList(i,i);
        }
        myList.insertList(20,0);
        System.out.print("链表元素为：");
        myList.output();
        System.out.println();
        myList.deleteList(2);
        System.out.print("链表元素为：");
        myList.output();
        System.out.println();
        myList.deleteList(0);
        System.out.print("链表元素为：");
        myList.output();
        System.out.println();
    }


}
