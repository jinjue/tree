package alg;

//获取金矿最优收益
public class GetBestGold {

    public static int getbestgold(int w ,int[] p,int[] g){
        int[] result = new int[w+1];
        for(int i=1;i<=g.length;i++){
            for(int j = w;j>=1;j--){
                if(j>=p[i-1]){
                    result[j] = Math.max(result[j],result[j-p[i-1]]+g[i-1]);
                }
            }
        }
        return result[w];
    }

    public static void main(String[] args) throws Exception{
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};

        System.out.println("最优收益："+getbestgold(w,p,g));

    }

}
