package alg;

//删去k个数值后的最小值
public class RemoveKMin {
    //删去k个数值后的最小值
    public static String removeK(String number,int k){
        String  newnumber = number;
        for(int i=1;i<=k;i++){
            boolean iscut = false;
            for(int j=0;j<newnumber.length()-1;j++){
                if(newnumber.charAt(j)>newnumber.charAt(j+1)){
                    newnumber = newnumber.substring(0,j)+newnumber.substring(j+1,newnumber.length());
                    iscut = true;
                    break;
                }
            }
            if(!iscut){
                newnumber = newnumber.substring(0,newnumber.length()-2);
            }
            newnumber = remove0(newnumber);
        }
        if(newnumber.length() == 0){
            return "0";
        }
        return newnumber;
    }

    //删去k个数值后的最小值改进
    public static String removeK2(String number,int k){
        int newlength = number.length()-k;
        char[] stack = new char[number.length()];
        int top = 0;
        for(int i = 0;i<number.length();i++){
            char num = number.charAt(i);
            while(top>0 && stack[top-1]>num && k>0){
                top-=1;
                k-=1;
            }
            stack[top++] = num;
        }
        int border = 0;
        while(border<newlength && stack[border] == '0'){
            border++;
        }
        return border == newlength?"0":new String(stack,border,newlength-border);

    }


    //清除左侧的0
    public static String remove0(String number){
        for (int i=0;i<number.length()-1;i++){
            if(number.charAt(0)!='0'){
                break;
            }
            number =number.substring(1,number.length());
        }
        return number;
    }
    public static void main(String[] args) throws Exception{
        System.out.println(removeK("30211",1));
        System.out.println(removeK2("302115932",3));

    }

}
