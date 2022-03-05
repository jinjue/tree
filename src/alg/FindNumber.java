package alg;

public class FindNumber {

    //问题描述1  假设是1`10的整数
    public static int findnum1(int[] array){
        int sum = 0;
        for(int i=1;i<=array.length;i++){
            sum+=i;
        }
        for(int i=0;i<array.length-1;i++){
            sum=sum-array[i];
        }
        return sum;
    }

    //问题扩展1
    public static int findnum2(int[] array){
        int number = 0;
        for(int i=0;i<array.length;i++){
            number^=array[i];
        }
        return number;
    }

    //问题拓展2
    public static int[] findnum3(int[] array){
        int[] result = new int[2];
        int number = findnum2(array);
        if(number == 0) return null;
        int border = 1;
        while(0==(number&border)){
            border<<=1;
        }
        for(int i=0;i<array.length;i++){
            if(0==(array[i]&border)){
                result[0]^=array[i];
            }
            else {
                result[1]^=array[i];
            }
        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        int[] array = new int[]{1,2,3,5,6,7,8,9,10};
        System.out.println("没有出现的整数是："+findnum1(array));
        int[] array2 = new int[]{3,2,3,5,5,7,10,7,10};
        System.out.println("只出现过奇数次的整数是："+findnum2(array2));

        int[] array3 = new int[]{3,2,3,3,7,10,7,10};
        int[] result = findnum3(array3);
        System.out.println("出现过奇数次的两个整数是："+result[0]+" "+result[1]);


    }

}
