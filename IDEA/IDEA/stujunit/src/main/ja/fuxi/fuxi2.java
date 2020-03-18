package ja.fuxi;


import java.util.Arrays;

public class fuxi2 {
    public static  void main(String[] args) {
        double x = 1 - 9.0 / 10;
        System.out.println(x);
        System.out.println(Math.abs(x));
        System.out.println(Math.abs(x-0.1));
        System.out.println(Math.abs(x - 0.1)<0.00001);
        String a="hello";
        String b ="Hello".toLowerCase();
        if(a.equals(b)){
            //equals判断内容是否是一致
            //
            System.out.println(a+b);
        }else {
            System.out.println("a");
        }

        char A = 'A';
        char zh = '中';
        System.out.println(A);
        System.out.println(zh);

        System.out.println(1+(int)(Math.random() * 3));//Math.random() * 3)为0~3的随机浮点数   （int）强制类型转换为int型
        int i=1;
        int sum= 0;
        do {
            sum = sum+i;
            i++;
        }while(i<=10);
        System.out.println(sum);

        int su = 0;
        int m = 20;
        int n = 100;
        // 计算m到n的和
        do {
            su=su+m;
            m++;
        } while (m<=n);
        System.out.println(su);
        //for each便利
        String[] ns=new String[]{"xyl","qwe","qwe","4eqw","5qq","6qq"};
        for (String nn : ns) {
            System.out.println(nn);
        }

        int[] yxl={1,2,3,4,5,6,7};
        for (int iii = yxl.length-1;iii>=0;iii--){
            System.out.println(yxl[iii]);
        }
        //java 排序方法  升序底层
        int[] ws = { 1, 4, 9, 25 , 16 };
        System.out.println(Arrays.toString(ws));//排序前
        for(int yx = 0;yx<ws.length-1;yx++){
            for (int xa=0;xa<ws.length -yx -1 ; xa++) {
                if (ws[yx] > ws[yx + 1]) {
                    int jh = ws[yx];
                    ws[yx] = ws[yx + 1];
                    ws[yx + 1] = jh;
                }
            }
        }
        System.out.println(Arrays.toString(ws));//排序后


        int wa = 0;
        for (int aw : ws) {
                wa =wa+aw;
        }
        System.out.println(wa); // 55
    }
}
