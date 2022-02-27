package DataStru;

import java.util.Arrays;

//优先队列
public class PrioQue {
    private int[] array;
    private int Qlength=0;

    public PrioQue(int number){
        array = new int[number];
    }

    //入队
    public void enterQ(int element){

        if(Qlength >= array.length){
            expand();
        }

        array[Qlength++] = element;
        //System.out.println(Qlength);
        upadjust();
    }

    //出队
    public void outQ() throws Exception{
        if(Qlength<=0){
            throw  new Exception("队列为空");
        }
        int top = array[0];

        array[0] = array[--Qlength];
        downadjust();
        System.out.println("元素："+top+"出队");
    }

    //对优先队列进行上浮调整
    public void upadjust(){
        int child = Qlength-1;
        int father = (child-1)/2;
        int temp = array[child];
        while(child>0 && temp>array[father]){
            array[child] = array[father];
            child = father;
            father = father/2;
            //System.out.println(child+"  "+father);

        }
        array[child] = temp;
    }

    //对优先队列进行下沉调整
    public void downadjust(){


        int father = 0;
        int temp = array[father];
        int child = 1;

        while(child<Qlength){
            //定位到值更大的孩子进行交换调整
            if(child+1<Qlength && array[child+1]>array[child]){
                child++;
                //System.out.println(child);
            }

            if (temp >= array[child]) break;
            array[father] = array[child];
            father = child;
            child = child*2+1;
            //System.out.println(child+"  "+father);
        }
        array[father] = temp;
    }

    //队列扩容
    public void expand(){
        int Newl = this.Qlength*2;
        this.array = Arrays.copyOf(this.array,Newl);
    }


    public static void main(String[] args) throws Exception{
        PrioQue prioQue = new PrioQue(10);
        for(int i=0;i<7;i++){
            prioQue.enterQ(i);
        }
        prioQue.enterQ(100);
        prioQue.outQ();
        prioQue.outQ();
        prioQue.outQ();
    }

}
