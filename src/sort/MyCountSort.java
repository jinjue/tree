package sort;

import java.util.Arrays;

//计数排序
public class MyCountSort {

    //计数排序
    public static int[] countsort(int[] array){
        int max = array[0];
        for(int i = 1;i<array.length;i++){//获取序列的最大值
            if(array[i]>max){
                max = array[i];
            }
        }
        //根据序列最大值来确定数组长度
        int[] count = new int[max+1];
        for(int i = 0;i<array.length;i++){
            count[array[i]]++;//对应数组下标+1
        }
        int sum = 0;
        int[] outarray = new int[array.length];
        for(int i = 0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                outarray[sum++]=i;
            }
        }
        return outarray;
    }

    //计数排序优化
    public static int[] countsort2(int[] array){
        int max = array[0];
        int min = array[0];
        for(int i = 1;i<array.length;i++){//获取序列的最大值
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        int distance = max - min;
        //根据序列最大值来确定数组长度
        int[] count = new int[distance+1];
        for(int i = 0;i<array.length;i++){
            count[array[i]-min]++;//对应数组下标+1
        }
        for(int i = 1;i<count.length;i++){//后面的元素等于前面元素之和
            count[i] += count[i-1];
        }
        int[] outarray = new int[array.length];
        for(int i = array.length-1;i>=0;i--){
            outarray[count[array[i]-min]-1] = array[i];
            count[array[i]-min]--;
        }
        return outarray;
    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
        int[] outarray = countsort(array);
        System.out.println("计数排序:  "+ Arrays.toString(outarray));

        int[] array2 = new int[]{94,93,96,99,95,97,98,};
        outarray = countsort2(array2);
        System.out.println("计数排序（优化:  "+ Arrays.toString(outarray));

    }


}

