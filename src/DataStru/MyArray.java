package DataStru;

import java.util.Arrays;

public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int number){
        this.array = new int[number];
        size = 0;
    }

    //判断数组是否已满
    public boolean IsFull(int maxsize){
        if(maxsize<size) return false;
        return true;
    }

    //插入数据
    public void insertA(int data,int index) throws Exception{
        if(size<index||index<0){
            throw  new Exception("超出数组范围");
        }
        if(!IsFull(array.length)){
            expand();
        }

        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=data;
        size++;
    }

    //删除数组
    public void deleteA(int index)throws Exception{
        if(size==0){
            throw  new Exception("数组为空");
        }
        if(size<index||index<0){
            throw  new Exception("超出数组范围");
        }
        for(int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
        array[size]=0;
    }

    //数组扩容
    public void expand(){
        int Newl = this.size*2;
        this.array = Arrays.copyOf(this.array,Newl);
    }

    //数组输出
    public void output(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        MyArray myArray = new MyArray(10);
        for(int i=0;i<10;i++){
            myArray.insertA(i,i);
        }
        System.out.print("数组元素为：");
        myArray.output();
        System.out.println();
        myArray.deleteA(3);
        System.out.print("数组元素为：");
        myArray.output();


    }

}
