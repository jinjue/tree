package sort;

import java.util.Arrays;

//鸡尾酒排序
public class MyCockSort {

    public static void cocktailSort(int array[]){
        for(int i = 0;i<array.length/2;i++){
            int flag = 0;
            //从左往右进行比较
            for (int j = i;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){

                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
            flag = 0;
            //从右往左进行比较
            for (int j = array.length-i-1;j>i;j--){
                if(array[j]<array[j-1]){

                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0){
                break;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
        cocktailSort(array);
        System.out.println("鸡尾酒排序:  "+ Arrays.toString(array));

    }

}
