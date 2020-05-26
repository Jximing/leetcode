package secondstage;

public class BitMap {

    private int length;
    private byte[] array;

    public BitMap(int length) {
        this.length = length;
        array = new byte[length >>> 3];
    }

    public boolean get(int value) {
        //获取值在哪个数组
        int site = value >>> 3;
        byte temp = array[site];
        //获取值是第几位
        int index = value & 7;
        //如果对应位为1代表存在
        return (temp >>> (7 - index) & 1) != 0;
    }

    public void set(int value, boolean flag) {
        //获取值在哪个数组
        int site = value >>> 3;
        byte temp = array[site];
        //获取值是第几位
        int index = value & 7;

        byte comp = (byte) (1 << (7 - index));
        if (flag) {//设置1
            array[site] = (byte) (temp | comp);//取或(0.. 1 0..)
        } else {//设置0
            comp = (byte) ~comp;//取反
            array[site] = (byte) (temp & comp);//相与(1.. 0 1..)
        }
    }

    public void add(int index) {
        set(index, true);
    }

    public void delete(int index) {
        set(index, false);
    }

    public int getLength() {
        return length;
    }
}
