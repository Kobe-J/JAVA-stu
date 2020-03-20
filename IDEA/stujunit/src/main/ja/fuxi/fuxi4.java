package ja.fuxi;

import java.util.Scanner;

public class fuxi4 {


    public static void main(String[] args) {

    }
        public  void aa(){
            String s1 = new String("Hello");
            String s2 = new String("Hello1");
            if (s1.equals(s2)) {
                System.out.println("!!!");
            } else {
                System.out.println("####");
            }
            int b = 1;
            System.out.println(b);
            b = 2;
            System.out.println(b);

            int n = 100; // 定义变量n，同时赋值为100
            System.out.println("n = " + n); // 打印n的值

            n = 200; // 变量n赋值为200
            System.out.println("n = " + n); // 打印n的值

            int x = n; // 变量x赋值为n（n的值为200，因此赋值后x的值也是200）
            System.out.println("x = " + x); // 打印x的值

            x = x + 100; // 变量x赋值为x+100（x的值为200，因此赋值后x的值是200+100=300）
            System.out.println("x = " + x); // 打印x的值
            System.out.println("n = " + n); // 再次打印n的值，n应该是200还是300？

            int a = 200;
            int sum = (1+a)*a/2; //计算前N个自然数的和可以根据公示：
            System.out.println(sum);

            double x1 = 1.0 / 10;
            double y = 1 - 9.0 / 10;
            // 观察x和y是否相等:
            System.out.println(x1);
            System.out.println(y);
            double r = Math.abs(x1 - y);
            // 再判断绝对值是否足够小:
            if (r < 0.00001) {
                System.out.println("可以认为相等");
            } else {
                System.out.println("不相等");
            }
            int age = 7;
            boolean isPrimaryStudent=6<age&6<12;
            System.out.println(isPrimaryStudent?"yes" : "no");
            String a1 = "Hello";
            String a2 = "world";
            String s = a1 + " " + a2 + "!";
            System.out.println(s);


            String n1 = "age is " + age;
            System.out.println(n1);
            String yxl = "我爱\n"+"我的家乡\n"+"哈尔滨";
            System.out.println(yxl);
            String ws = "hello";
            System.out.println(ws); // 显示 hello
            ws = "world";
            System.out.println(ws); // 显示 world

            String as = "hello";
            as = "world";
            String t = as;
            System.out.println(t);

            int q= 1;
            int w=23;
            int e=123;
            String qwe = String.valueOf(q + w + e);
            System.out.println(qwe);
            System.out.println(qwe.length());
            System.out.println(qwe.charAt(0));
            int[] l=new int[]{1,2,3,4,5,6,7,8};
            System.out.println(l.length);
            System.out.println(l[2]);
            String[] fff;
            fff=new String[]{"aa","bb","cc"};
            String ddd=fff[1];
            fff[1]="dd";
            System.out.println(ddd);
            double asdd=1.22343;//double是双精度类型，精度是17位有效数字
            System.out.printf("%.2f\n",asdd);

            float aaaaa=50.2131212f;//注意float是8位有效数字，第7位数字将会产生四舍五入
            System.out.println(aaaaa);


            //Scanner   创建Scanner对象并传入System.in。System.out代表标准输出流，
            // 而System.in代表标准输入流。直接使用System.in读取用户输入虽然是可以的，
            // 但需要更复杂的代码，而通过Scanner就可以简化后续的代码。
            //有了Scanner对象后，要读取用户输入的字符串，
            // 使用scanner.nextLine()，要读取用户输入的整数，
            // 使用scanner.nextInt()。
            // Scanner会自动转换数据类型，因此不必手动转换。
            Scanner in = new Scanner(System.in);
            System.out.print("请输入您的家乡： ");
            String home = in.nextLine();
            System.out.print("请输入您的姓名：");
            String name = in.nextLine();
            System.out.print("请输入您的年龄：");
            int  age1= in.nextInt();
            System.out.printf("欢迎来自%s的%d岁少年%s\n",home,age1,name);
            System.out.print("Input your prev: ");
            int prev = in.nextInt();
            System.out.print("Input your score: ");
            int score = in.nextInt();
            double percent = 1.0*(score-prev)/prev*100;
            if(score>prev) {
                System.out.printf("成绩提高了%.1f%%", percent);
            }else {
                System.out.printf("成绩下降了%.1f%%",percent);
            }






        }
}
