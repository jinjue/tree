package alg;

import java.util.Arrays;

//寻找全排列的下一个数
public class FindNearMax {

    public static int[] getnearmax(int[] array) throws Exception{
        int border = getborder(array);
        if(border == 0){
            throw new Exception("不存在比该数更大的数");
        }
        int[] copyarray = Arrays.copyOf(array,array.length);
        exchange(copyarray,border);
        reverse(copyarray,border);
        return copyarray;

    }
    //找到逆序的边界
    public static int getborder(int[] array){
        for(int i=array.length-1;i>0;i--){
            if(array[i]>array[i-1]){
                return i;
            }
        }
        return 0;
    }
    //将边界前一个元素和逆序区域内大于它的最小元素进行交换
    public static int[] exchange(int[] array,int border){
        for(int i=array.length-1;i>0;i--){
            if(array[border-1]<array[i]){
                int temp = array[border-1];
                array[border-1] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
    //把原来的逆序区域转为顺序状态
    public static int[] reverse(int[] array,int border){
        for(int i=border,j=array.length-1;i<j;i++,j--){
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
    //数组输出
    public void output(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception{
        FindNearMax nearMax = new FindNearMax();
        int[] array = {1,2,3,6,4,4};
        System.out.print("数组元素为：");
        nearMax.output(array);
        array = getnearmax(array);
        System.out.print("全排列的下一个数为：");
        nearMax.output(array);

    }


}
