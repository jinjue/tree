package alg;

import DataStru.MyList;
import pojo.mylist;

//判断链表有环
public class loop {

    //判断是否有环
    public static boolean isloop(mylist head){
        mylist p1 = head;
        mylist p2 = head;
        while(p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                return true;
            }
        }

        return false;
    }

    //求环长
    public static int looplength(mylist head){
        mylist p1 = head;
        mylist p2 = head;
        int length = 0;
        int flag = 0;
        while(p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(flag!=0) length++;
            if(p1==p2){
                flag++;
            }
            if(flag==2) break;
        }
        return length;
    }

    //求入环点
    public static int getloopnode(mylist head){
        mylist p1 = head;
        mylist p2 = head;
        int flag = 0;
        while(p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1==p2){
                flag++;
                if(flag!=2) p1 = head;
                else return p2.next.data;
            }
        }
        return 0;
    }


    public static void main(String[] args) throws Exception {
        mylist node1 = new mylist(1);
        mylist node2 = new mylist(2);
        mylist node3 = new mylist(3);
        mylist node4 = new mylist(4);
        mylist node5 = new mylist(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        if(isloop(node1)){
            System.out.println("有环路");
            System.out.println("环长为："+looplength(node1));
            System.out.println("入环点为："+getloopnode(node1));
        }

        else{
            System.out.println("没有环路");
        }


    }


}
