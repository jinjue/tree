package alg;


public class BitMap {
    private long[] words;//每一个word是一个long类型元素，对应一个64位二进制数据
    private int size;//bitmap的位数大小

    public BitMap(int size){
        this.size = size;
        this.words = new long[(getIndex(size-1)+1)];
    }


    //定位bitmap某一位所对应的map
    private int getIndex(int bitindex){
        return bitindex >> 6;//左移6位，相当于除以64
    }
    //将bitmap某一位设置为true
    public void setbit(int bitindex) throws Exception{
        if(bitindex<0||bitindex>size-1){
            throw new IndexOutOfBoundsException("超出范围");
        }
        int wordindex = getIndex(bitindex);//定位到word中的对应的long元素
        words[wordindex] |= (1L<<bitindex);//通过与运算修改long元素的值
    }
    //判断bitmap的某一位是不是true
    public boolean getBit(int bitindex){
        if(bitindex<0||bitindex>size-1){
            throw new IndexOutOfBoundsException("超出范围");
        }
        int wordindex = getIndex(bitindex);
        return (words[wordindex] & (1L<<bitindex)) !=0;
    }

    //bitmap的与运算
    public void bitand(int bit1,int bit2){
        int word1 = getIndex(bit1);
        int word2 = getIndex(bit2);
    }



    public static void main(String[] args) throws Exception{
        BitMap bitMap = new BitMap(128);
        bitMap.setbit(126);
        bitMap.setbit(75);
        System.out.println(bitMap.getBit(126));
        System.out.println(bitMap.getBit(76));
    }




}
