package alg;

//计算两个大整数相加
public class BigSum {

    public static String bignmbersum(String numberA,String numberB){
        int length = numberA.length()>numberB.length()?numberA.length():numberB.length();
        int[] arrayA = new int[length+1];
        int[] arrayB = new int[length+1];
        int[] result = new int[length+1];
        for(int i=0;i<numberA.length();i++){
            arrayA[i] = numberA.charAt(numberA.length()-1-i)-'0';
        }
        for(int i=0;i<numberB.length();i++){
            arrayB[i] = numberB.charAt(numberB.length()-1-i)-'0';
        }
        for(int i=0;i<result.length;i++){
            result[i] = 0;
        }

        for(int i=0;i<result.length-1;i++){
            result[i] = (arrayA[i]+arrayB[i])%10+result[i];
            result[i+1] = (arrayA[i]+arrayB[i])/10;
        }

        StringBuilder s = new StringBuilder();
        boolean find = false;
        for(int i = result.length-1;i>=0;i--){
            if(!find){
                if(result[i]==0)
                    continue;
                find = true;
            }
            s.append(result[i]);
        }
        return s.toString();
    }

    public static void main(String[] args) throws Exception{
        System.out.println(bignmbersum("30211","302115932"));


    }


}
