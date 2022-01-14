package day2;

/**
 * 前缀和
 * 一个数组 输入两个索引位置 算出之间的和  使用非常频繁
 */
public class SumProblemDemo {

    public static final int[] ARR = {1, 6, 8, 55, 32, 64, 4, 65, 21, 84, 45};

    /**
     * 0  1  2  3  4  5  6
     * 0
     * 1
     * 2
     * 3
     * 4
     * 5
     * 6
     * <p>
     * 横向的代表的是R 最后的索引位置  竖向的代表的是L 开始的索引位置
     * 0 0 表示从0开始 到0 结束位置的和 就是arr[0] 1
     * 0 1 从0 开始 1 结束  表示 arr[0] + arr[1]
     * 如果L 比 R 大 不存值  因为不成立
     * 这样当你输入两个位置的时候 可以直接从二维数组的位置直接拿到结果
     * 数组存值 大概是 N*N/2
     */
    public static final int[][] result1 = new int[ARR.length][ARR.length];


    /**
     * 这个数组和原来的数组一样长 但是他每个位置存的值 是原数组 这个位置和他前面位置的累加和
     * result2[0] = arr[0]
     * result2[1] = result2[0]+ arr[1]
     * result2[2] = result2[1]+arr[2]
     * result2[3] = result2[2]+arr[3]
     * result2[4] = result2[3]+arr[4]
     * 这样 当你输入两个位置的时候 若起始位置是0 则求和结果就是result2[R]
     * 若不为0 则结果为 result[R]-result[L-1]
     */
    public static final int[] result2 = new int[ARR.length];


    static {
        handlerResult1();
        handlerResult2();
    }

    public static void handlerResult1() {
        for (int i = 0; i < ARR.length; i++) { //外层代表竖列  内层代表横列
            for (int j = 0; j < ARR.length; j++) {
                if (i > j) {
                    continue;
                }
                if (i == j) {
                    result1[i][j] = ARR[i];
                } else {
                    result1[i][j] = result1[i][j - 1] + ARR[j];
                }

            }
        }
    }

    public static void handlerResult2() {
        result2[0] = ARR[0];
        for (int i = 1; i < ARR.length; i++) {
            result2[i] = result2[i - 1] + ARR[i];
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i <1000000 ; i++) {
            int a = (int) (Math.random() * ARR.length);
            int b = (int) (Math.random() * ARR.length);
            int right = Math.max(a,b);
            int left = Math.min(a,b);
            int sum1 = sum1(left, right);
            int sum2 = sum2(left, right);
            int sum3 = sum3(left, right);

            if(sum1 !=sum2 || sum2 !=sum3){
                System.out.println("left "+left);
                System.out.println("right "+right);
                System.out.println("sum1 "+sum1);
                System.out.println("sum2 "+sum2);
                System.out.println("sum3 "+sum3);
                break;
            }

        }

    }

    //循环累加
    public static int sum1(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            count += ARR[i];
        }
        return count;
    }

    public static int sum2(int left, int right) {
        return result1[left][right];
    }

    public static int sum3(int left, int right) {
        return left == 0 ? result2[right] : (result2[right] - result2[left-1]);
    }

}
