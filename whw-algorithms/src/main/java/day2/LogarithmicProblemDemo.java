package day2;

/**
 * 几个对数器题目
 * 1 已知一个函数可以概率相等的获取1-5 概率相等的获取23-65
 * 2 一个函数可以概率不等的获取到0-1 改成均等获取0-1
 */
public class LogarithmicProblemDemo {
    public static void main(String[] args) {
        int times = 10000000;
        int[] arr = new int[43];
        for (int i = 0; i < times; i++) {
            arr[d() - 23]++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + 23 + "-->" + arr[i]);
        }
        int[] arr1 = new int[2];

        for (int i = 0; i < times; i++) {
            arr1[f()]++;
        }
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i + "-->" + arr1[i]);
        }
    }

    //均等概率的获取1-5
    public static int a() {
        return (int) (Math.random() * 5 + 1);
    }

    //将a函数均等概率的获取1-5 改成均等概率的获取 0 1

    /**
     * 因为a函数 获取的概率是均等的 是奇数个 所以中间数 3 的时候跳过 再次获取
     * 当小于3 时 为0 大于3时为1 这样就可以直接得到函数 均等概率获取0 1
     */
    public static int b() {
        int result = 0;
        do {
            result = a();
        } while (result == 3);
        return result < 3 ? 0 : 1;
    }

    /**
     * 均等概率的获取23-65 65-23=42
     * 要想均等概率的获取23-65  先获取均等概率0-42 然后在加23 就可以了
     * 将函数a处理后得到均等概率获取0 1 的函数b
     * 0  0  0  0  0  0
     * 32 16 8  4  2  1
     * 用6个bit位 可以获取的最大的数为63
     * 42也在范围内 这样就可以获取到了
     * 因为函数b可以均等概率的获取0 1  每一次的函数b 当作一个bit位
     * 每一数经过函数b获取6次bit位 可以均等的得到0-63之间的数
     * 大于42的数不要 重新随机 这样就可以获取到均等概率的0-42
     * 在加上23 就可以获取到均等概率的23-65 之间的数
     */
    public static int c() {
        int ans = (b() << 5) + (b() << 4) + (b() << 3) + (b() << 2) + (b() << 1) + (b() << 0);
        if (ans > 42) {
            ans = c();
        }
        return ans;
    }

    public static int d() {
        return c() + 23;
    }


    //该函数获取0的概率位0.84 1的概率位0.16
    public static int e() {
        return Math.random() > 0.84 ? 1 : 0;
    }


    //根据函数e 改成均等的获取 0 1

    /**
     * 获取 0 0 的概率位 0.84*0.84
     * 获取 1 1 的概率位 0.16*0.16
     * 获取 0 1 的概率位 0.84 * 0.16
     * 获取 1 0 的概率位 0.16 *0.84
     * 获取两次 当两次结果不一致时 概率一样 这样就可以均等的获取到 0 1
     * 0 1 ==> 1
     * 1 0 ==> 0
     */
    public static int f() {
        int ans = 0;
        do {
            ans = e();
        } while (ans == e());

        return ans;
    }


}
