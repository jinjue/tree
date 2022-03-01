package sort;

import java.util.Arrays;

//堆排序
public class MyHeapSort {

    //下沉调整
    public static void downadjust(int[] array, int father,int length){


        int temp = array[father];
        int child = 2*father+1;

        while(child<length){
            //定位到值更大的孩子进行交换调整
            if(child+1<length && array[child+1]>array[child]){
                child++;
                //System.out.println(child);
            }

            if (temp >= array[child]) break;
            array[father] = array[child];
            father = child;
            child = child*2+1;
            //System.out.println(child+"  "+father);
        }
        array[father] = temp;
    }

    //堆排序（递增
    public static void heapSort(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            downadjust(array,i,array.length);
        }
        //System.out.println("堆排序:  "+ Arrays.toString(array));

        for(int i=array.length-1;i>0;i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;

            downadjust(array,0,i);
        }

    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
        heapSort(array);
        System.out.println("堆排序:  "+ Arrays.toString(array));

    }


}
