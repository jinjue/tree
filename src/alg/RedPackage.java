package alg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {

    public static List<Integer> divide(Integer totalmoney,Integer totalpeopel){
        List<Integer> amountList = new ArrayList<Integer>();
        Integer restmoney = totalmoney;
        Integer restpeople = totalpeopel;
        Random random = new Random();
        for(int i = 0;i < totalpeopel-1;i++){
            int amount = random.nextInt(restmoney/restpeople*2 - 1)+1;
            restpeople--;
            amountList.add(amount);
        }
        amountList.add(restmoney);
        return amountList;
    }

    public static void main(String[] args) throws Exception{
        List<Integer> amountList = divide(1000,10);
        for(Integer amount : amountList){
            System.out.println("抢到金额："+new BigDecimal(amount).divide(new BigDecimal(100)));
        }

    }



}

