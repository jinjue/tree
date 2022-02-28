package sort;

import java.util.Arrays;

//快速排序
public class MyQuickSort {


    public static void quicksort(int[] array, int start,int end){
        if(start >= end) return;
        //int pivot = quicksortdouble(array,start,end);
        int pivot = quicksortsingle(array,start,end);
        quicksort(array,start,pivot-1);
        quicksort(array,pivot+1,end);
    }
    //双边循环法
    public static int quicksortdouble(int[] array, int start,int end){
        int pivot = array[start];
        int low = start;
        int high = end;

        while(low!=high){
            while(low<high &&array[high] >pivot){//high指针,向左移动
                high --;
            }
            while(low<high &&array[low] <=pivot){//low指针,向右移动
                low ++;
            }
            if(low<high){//交换指针所指的元素
                int temp = array[low];
                array[low] = array[high];
                array[high] = temp;
            }
        }

        array[start] =array[low];
        array[low] = pivot;
        return low;
    }

    //单边循环
    public static int quicksortsingle(int[] array, int start,int end){
        int pivot = array[start];
        int mark = start;
        for(int i = start+1;i<= end;i++){//从mark后一位元素开始比较
            if(array[i]<pivot){//小于基准元素
                mark++;
                int temp = array[mark];
                array[mark] = array[i];
                array[i] = temp;
            }


        }
        array[start] =array[mark];
        array[mark] = pivot;
        return mark;
    }

    public static void main(String[] args) throws Exception{
//        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
//        quicksort(array,0,array.length-1);
//        System.out.println("快速排序（双边循环法:  "+ Arrays.toString(array));

        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
        quicksort(array,0,array.length-1);
        System.out.println("快速排序（单边循环法:  "+ Arrays.toString(array));
    }

}
