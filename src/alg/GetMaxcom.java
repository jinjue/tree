package alg;

//求最大公约数
public class GetMaxcom {

    //使用辗转相除法求取
    public static int maxcommon(int a,int b){
        int big = a>b?a:b;
        int small = a<b?a:b;
        if(big%small == 0) return small;
        return maxcommon(big%small,small);
    }

    //使用更相减损术
    public static int maxcommon2(int a,int b){
        if(a == b) return a;
        int big = a>b?a:b;
        int small = a<b?a:b;

        return maxcommon(big-small,small);
    }

    //使用更相减损术基础上的移位运算
    public static int maxcommon3(int a,int b){
        if(a == b) return a;
        //如果a，b都为偶数
        if((a&1)==0 && (b&1)==0) return maxcommon3(a>>1,b>>1)<<1;
        //如果a是偶数，b是奇数
        else if((a&1)==0 && (b&1)!=0) return maxcommon3(a>>1,b);
        //如果b是偶数，a是奇数
        else if((a&1)!=0 && (b&1)==0) return maxcommon3(a,b>>1);
        //如果a，b都为奇数
        else{
            int big = a>b?a:b;
            int small = a<b?a:b;
            return maxcommon(big-small,small);
        }

    }


    public static void main(String[] args){
        System.out.println(maxcommon(16,12));
        System.out.println(maxcommon2(16,12));
        System.out.println(maxcommon3(200,12));
    }


}
