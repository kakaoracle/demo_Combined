package 二分法;
/*
* 二分法,旨在给定一个数组与其中一个值,计算出其在数组中的位置
*
* */
public class Sec {

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println("目标的数组下标为:" + getResult1(a, 3));
    }

    // 死循环的条件不对,并且不一定是奇数数组命中.因此用下面的
    public static int getResult(int[] a,int target){
        int length = a.length;

        while (true){
            int midIndex = length/2;
            if (a[midIndex] == target){
                return target;
            }
            if ( a[midIndex] < target){
                length = midIndex;
            }
            if ( a[midIndex] > target){
                length = midIndex + a.length;
            }
        }
    }

    // 不用递归的写法
    // 注意点1, 求中值时虽然等价于(left + right)/2,但是这种当数极大时会溢出
    // 注意点2, +1和-1的作用是减少运算步骤,不写也行
    public static int getResult1(int[] a,int x){
        int leftIndex = 0;
        int rightIndex = a.length - 1;
        while (leftIndex <= rightIndex) {
            int middle = leftIndex + (rightIndex - leftIndex) / 2;
            if (x > a[middle])
                leftIndex = middle + 1;
            if (x < a[middle])
                rightIndex = middle - 1;
            else
                return middle;
        }
        return -1;
    }


}
