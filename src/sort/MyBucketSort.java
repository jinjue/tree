package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

//桶排序
public class MyBucketSort {


    //桶排序
    public static double[] bucketsort(double[] array){
        double max = array[0];
        double min = array[0];
        for(int i = 1;i<array.length;i++){//获取序列的最大值
            if(array[i]>max){
                max = array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        double distance = max - min;
        //建立个数和序列长度一样的桶
        int number = array.length;
        //初始化桶
        ArrayList<LinkedList<Double>> bucketlist = new ArrayList<LinkedList<Double>>(number);
        for(int i=0;i<number;i++){
            bucketlist.add(new LinkedList<Double>());
        }
        //将序列元素放入桶中
        for(int i=0;i<array.length;i++){
            int num = (int) ((array[i]-min)*(number-1)/distance);
            bucketlist.get(num).add(array[i]);
        }
        //对桶内元素进行排序
        for(int i=0;i<bucketlist.size();i++){
            Collections.sort(bucketlist.get(i));
        }

        //输出全部元素
        double[] outarray = new double[array.length];
        int index = 0;
        for(LinkedList<Double>list:bucketlist){
            for(double element:list){
                outarray[index] = element;
                index++;
            }
        }
        return outarray;
    }

    public static void main(String[] args) throws Exception{
        double[] array = new double[]{4.7,4.3,8.6,0.22,1.5,5.7,0.8,6.9,1.0};
        double[] outarray = bucketsort(array);
        System.out.println("计数排序:  "+ Arrays.toString(outarray));


    }


}
