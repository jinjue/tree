package sort;


import java.util.Arrays;

//冒泡排序
public class MyBubSort {


    //冒泡排序（原始
    public static void bubblesort(int array[]){
        int sum = 0;//记录排序趟数，方便比较
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            sum++;
        }
        System.out.println("经过："+sum+" 次排序");
    }
    //冒泡排序（判断未结束排序的数列是否已经有序，若有序则提前结束
    public static void bubblesort2(int array[]){
        int sum = 0;
        for(int i=0;i<array.length;i++){
            int flag = 0;//记录是否发生交换
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    flag = 1;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            sum ++;
            if(flag == 0){//若这一趟中没有交换，意味着后面的序列已经有序，可以退出
                break;
            }
        }
        System.out.println("经过："+sum+" 次排序");
    }

    //冒泡排序（记录数列的无序数列边界
    public static void bubblesort3(int array[]){
        int sum = 0;
        int lastex = 0;//记录最后交换的位置
        int border = array.length - 1;//记录无序数列的边界
        for(int i=0;i<array.length;i++){
            int flag = 0;
            for(int j=0;j<border;j++){//如果序列已经有序，则缩短每次要比较的边界
                if(array[j]>array[j+1]){
                    flag = 1;
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    lastex = j;
                }
            }
            border = lastex;
            sum ++;
            if(flag == 0){
                break;
            }
        }
        System.out.println("经过："+sum+" 次排序");
    }



    public static void main(String[] args) throws Exception{
        int[] array = new int[]{4,3,6,2,5,7,8,9,10};
        bubblesort(array);
        System.out.println("冒泡排序（原始:  "+ Arrays.toString(array));

        int[] array2 = new int[]{4,3,6,2,5,7,8,9,10};
        bubblesort2(array2);
        System.out.println("冒泡排序（优化1:  "+ Arrays.toString(array2));

        int[] array3 = new int[]{4,3,6,2,5,7,8,9,10};
        bubblesort2(array3);
        System.out.println("冒泡排序（优化2:  "+ Arrays.toString(array3));

    }


}
