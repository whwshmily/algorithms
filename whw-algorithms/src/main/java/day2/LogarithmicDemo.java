package day2;

/**
 * 对数器
 * Math.random() 获取数的范围是[0,1) 并且获取的概率是相同的 均等的
 * 获取x这个数的概率就是x
 */
public class LogarithmicDemo {


    public static void main(String[] args) {
        testLogarithmic(0.66);
        testPow(0.33);
    }


    /**
     * 获取[0,1) 之间的数  使他的概率为x的次方
     * 这样就可以获取到 是因为
     * 第一次获取 0-1 概率 是x  第二次获取 也是 x
     * 取最大值 这样范围还是0-x 经过两次之后概率就是x的次方
     * 因为是取max 所引 俩次都必须扔到这个范围才能得到这个x 否则就有可能得不到
     *
     */
    public static double xToPow(){
        return Math.max(Math.random(),Math.random());
        /**
         *  return Math.min(Math.random(),Math.random());
         *
         *  获取最小值  假设获取这个数为 x
         *  因为取最小值 所引两次只要有一次进入0-x范围 就能得到x
         *  所以计算概率应该 计算两次都不在 0-x的概率 1-x
         *  所以得到x 的概率为 1- (1-x)的平方
         *
         */
    }


    public static void testPow(double result){
        int times = 1000000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            double ans = xToPow();
            if (ans < result){
                count++;
            }
        }

        System.out.println("x----->"+Math.pow(result,2));
        System.out.println("实测的结果--->"+(double)count/times);
    }


    //测试 100万次的结果 概率是否一致
    public static void testLogarithmic(double result){
        int times = 1000000;
        int count = 0;
        for (int i = 0; i < times; i++) {
            double ans = Math.random();
            if (ans < result){
                count++;
            }
        }

        System.out.println("x----->"+result);
        System.out.println("实测的结果--->"+(double)count/times);

    }


}
