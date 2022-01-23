package day5;

import java.util.HashSet;

/**
 * 用二进制存储数字
 * long 有64 bit 位 一个long类型的可以存储 0-63之间的数字
 */
public class BitMap {

    private long[] bitMaps;

    public BitMap(int num) {
        /**
         * >>>6 无符号右移6位 代表除以2的6次方 =64
         * 初始化数组的长度  因为 假设你存的数 0-63 之间 +64 )/64 =1
         * 因为一个就够了 long  有64个bit位
         * 大于63就需要 2个
         */
        bitMaps = new long[(num + 64) >> 6];
    }

    public void add(int num) {
        /**
         * 先找到这个数在哪个正数的位置 num/64
         * 在找到需要把哪一个二进制 标记为1  num%64 = num & 63 因为
         * 63  1 1 1 1 1 1 所引获得 num 后6个bit位的 1 就是余数
         * 要想把这个位置标记为 1 先获取这个位置为1 其他为0 的bit为 (1L<<(num & 63))
         * 然后进行或运算
         * 为什么是1L 因为1默认是int 只有32bit位 若超出num & 63 >32则出现错误
         */
        bitMaps[num >> 6] |= (1L << (num & 63));
    }

    /**
     * 删除 则表示 把那个bit位标记位0
     * 就是 先获取 那个位置为0 其他位置为1(add 取反) 然后进行& 运算
     */
    public void del(int num) {
        bitMaps[num >> 6] &= ~(1L << (num & 63));
    }

    /**
     * 判断这个数存不存在 就看这个位置 是否是1
     * 和 这个位置为1 其他全为0 的bit 位的数 进行&运算
     * 如果不为0 则存在
     */
    public boolean contains(int num) {
        return (bitMaps[num >> 6] & (1L << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<Integer>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.del(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
                break;
            }
        }
        System.out.println("测试结束！");
    }
}
