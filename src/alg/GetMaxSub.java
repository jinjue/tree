package alg;

import pojo.Bucket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

//无序数组排序后的最大相邻差
public class GetMaxSub {


    public static int maxsub(int[] array){
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
        if(distance == 0) return 0;
        //建立个数和序列长度一样的桶
        int number = array.length;
        //初始化桶
        Bucket[] buckets = new Bucket[number];
        for(int i=0;i<number;i++){
            buckets[i] = new Bucket();
        }
        //将序列元素放入桶中
        for(int i=0;i<array.length;i++){
            int num = (int) ((array[i]-min)*(number-1)/distance);
            if(buckets[num].min == null || buckets[num].min>array[i]){
                buckets[num].min = array[i];
            }
            if(buckets[num].max == null || buckets[num].max<array[i]){
                buckets[num].max = array[i];
            }
        }

        int leftmax = buckets[0].max;
        int maxd = 0;
        for(int i=1;i<array.length;i++){
            if(buckets[i].min == null) continue;
            if(buckets[i].min-leftmax > maxd){
                maxd = buckets[i].min - leftmax -1;
            }
            leftmax = buckets[i].max;
        }

        return maxd;
    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{2,6,3,4,5,10};
        System.out.println("最大相邻差为:  "+ maxsub(array));


    }



}
