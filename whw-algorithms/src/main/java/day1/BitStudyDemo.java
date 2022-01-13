package compute.day1;

public class BitStudyDemo {


    public static void main(String[] args) {
        System.out.println(-2>>>1);
        System.out.println(-2>>1);
        printBit(-2);
        int a = -2147483648;
        System.out.println(-a);
    }


    //计算int 类型的bit
    // & 运算 有0则0   当这个数和32位的每一个位置为1 其他位置为0 进行与运算 当结果为0是 说明这个数
    //在这个bit位置为0(bit为1对应的位置 因为他这个位置为1 &运算肯定不为0)
    private static void printBit(int num){
        for (int i = 31; i >=0 ; i--) {
            System.out.print((num & (1<<i)) == 0 ? 0 :1);
        }
        System.out.println();
    }

    /**
     * 为什么负数是取反加1 因为底层为了计算(+-/)更快
     * 一个数的相反数 是 这个数的取反+1  正数每一个数都对应一个负数
     * 当时最小的负数 的相反数还是他
     *
     */




}
