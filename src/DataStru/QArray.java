package DataStru;

public class QArray {
    private int[] array;
    private int front=0;
    private int rear=0;

    //用数组实现队列
    public QArray(int number){
        this.array = new int[number];
    }

    //入队
    public void enterQ(int element) throws Exception{
        if((rear+1)%array.length==front){
            throw  new Exception("队列已满");
        }
        array[rear] = element;
        rear = (rear+1)%array.length;
    }
    //出队
    public void outQ() throws Exception{
        if(rear==front){
            throw  new Exception("队列为空");
        }
        int dele_element = array[front];
        front = (front+1)%array.length;
        System.out.println("元素："+dele_element+"出队");
    }
    //输出队列
    public void outputQ(){
        for(int i = front; i!= rear ; i=(i+1)%array.length){
            System.out.print(array[i]+" ");
        }
    }

    public static void main(String[] args) throws Exception{
        QArray qArray =new QArray(10);
        for(int i=0;i<9;i++){
            qArray.enterQ(i);
        }
        System.out.print("队列元素为：");
        qArray.outputQ();
        System.out.println();
        for(int i=0;i<9;i++){
            qArray.outQ();
        }
    }

}
