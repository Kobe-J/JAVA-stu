package ja.fuxi;

import java.util.Arrays;

public class fuxi3 {
    public static void main(String[] args) {
        /*
        * Date 2019.10
        * yxl
        */


        int[] ns = { 1, 4, 9, 25 , 16 };
        System.out.println(Arrays.toString(ns));//排序前
        Arrays.sort(ns);
        System.out.println(Arrays.toString(ns));//第一次排序
        for (int begin = 0, end = ns.length - 1; begin < end; begin++, end--) { //倒序
            int temp = ns[end];
            ns[end] = ns[begin];
            ns[begin] = temp;
        }
        System.out.println(Arrays.toString(ns));//排序后

        int[][][]i = {
                {{1},{2},{3}},
                {{4},{5},{6}},
                {{7},{8},{9}}
        };
        System.out.println(i[0].length+i[1].length+i[2].length);
        System.out.println(Arrays.deepToString(i));//把多维数组转化为字符串
        for (int[][] a:i) {//循环遍历三维数组
            for (int[] b: a) {
                System.out.println(Arrays.toString(b));
            }
        }


    }
}
