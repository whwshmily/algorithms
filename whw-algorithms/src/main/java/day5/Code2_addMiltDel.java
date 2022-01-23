package day5;

/**
 * 加减乘除
 */
public class Code2_addMiltDel {


    public static int add(int a, int b) {
        /**
         * 两个数相加
         * 先将两个数进行 ^ 运算--不进位加  得到一个数
         * 然后将两个数进行 & 运算 得到两个数的进位信息 然后进行 进位 <<1 得到一个数
         *
         *  得到的这两个数的和 = a+b
         *
         * 得到这两个数之后  一直重复这个操作
         * 直到 & 运算得到0 这时 另一个数就是这两个数的和
         *
         * 计算机底层就是这么计算的
         */
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int subtraction(int a, int b) {
        /**
         * 两个数相减 就等于加上他的相反数 b的相反数是 ~b+1
         */
        return add(a, ~b + 1);
    }

    public static int multiplication(int a, int b) {
        /**
         * 乘法：
         *        0 1 1 0
         *        1 1 1 0
         *  值    0 0 0 0
         *     0 1 1 0
         *   0 1 1 0
         * 0 1 1 0
         * 相加  0000 + 0 1 1 0 0 + 0 1 1 000 + 011 00000
         */
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(a, ans);
            }
            b >>>= 1;
            a <<= 1;
        }
        return ans;
    }

    /**
     * 除法  a/b =c
     * a 的范围是 b*c ~ b*c+b-1之间
     * 就取最小值 a = b*c 假设 c是 0 1 1 0
     * a= b*2平方 + b*2的1次方
     * 所引 c的值就是 b<=a 时候的2的最高次方 然后 一直到最低次方 的和
     */

    public static int divide(int a, int b) {
        /**
         * 因为负数的最小值的相反数还是他自己 所引要单独判断
         */
        if (a == Integer.MIN_VALUE && b == Integer.MIN_VALUE) {
            return 1;
        } else if (a == Integer.MIN_VALUE) {
            if (b == -1) {
                //正数没有那么大的 所引返回最大值
                return Integer.MAX_VALUE;
            } else {
                a = Integer.MIN_VALUE + 1;
                int div = div(a, b);
                /**
                 * 分子是最小值
                 * 先 加+ 1 然后算出的结果 * b
                 * 用 最小值 - 上面的值 然后除以b  看能否除尽
                 * 如果能 结果要加上这个没有计算在内的结果
                 */
                return add(div((subtraction(Integer.MIN_VALUE, multiplication(div, b))),b), div);
            }
        } else if (b == Integer.MIN_VALUE) {
            //分母如果是 最小值 结果一定为0
            return 0;
        } else {
            return div(a, b);
        }

    }

    public static int div(int a, int b) {
        /**
         * 负数不能计算 所引先转成正数 然后根据符号 最后判断就好 是否取相反数
         */
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        /**
         * 这里让a 除以2 往 b 靠近 因为 如果b靠近a的话 前后有一个符号位 结果不准确
         */
        int ans = 0;
        for (int i = 30; i >= 0; i = subtraction(i, 1)) {
            if ((x >> i) >= y) {
                //因为一定是2的次方 所引将符号条件的二进制位标记为1即可
                ans |= (1 << i);
                //符合b右移最大的值减掉 然后剩余的值接着比较 一直到不符合条件
                /**
                 * a= b*2平方 + b*2的1次方
                 * 先 剪掉 2的平方 然后继续
                 */
                x = subtraction(x, y << i);
            }
        }
        //符合相同 不换符合 不同换 false ^ true = true 相同为false
        return isNeg(a) ^ isNeg(b) ? negNum(ans) : ans;
    }

    //获取相反数
    public static int negNum(int num) {
        return add(~num, 1);
    }

    //判断一个数时候是负数
    public static boolean isNeg(int num) {
        return num < 0;
    }

    public static void main(String[] args) {
        System.out.println(add(3, -2));
        System.out.println(subtraction(3, -2));
        System.out.println(multiplication(3, 2));

        System.out.println(multiplication(3, -2));
        System.out.println("=======");
        System.out.println(div(10, 2));
        System.out.println(div(10, -3));
        System.out.println(div(-2147483647,2));

    }
}
