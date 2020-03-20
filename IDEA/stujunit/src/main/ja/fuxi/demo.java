package ja.fuxi;

import java.util.Scanner;


/**
 * @author yxl
 * date 2020.3.16
 * 模拟简单的猜拳游戏
 * **/
public class demo {
    public static void main(String[] args) {
        System.out.println("请输入你的选择：");
        System.out.println(" 1: 石头");
        System.out.println(" 2: 剪刀");
        System.out.println(" 3: 布");
        String[] result = {"石头", "剪刀", "布"};// 用户输入:
        int choice = 0;
        while (choice != 1 && choice != 2 && choice != 3) {//符合条件继续执行 不符合条继续循环
            System.out.println("请输入：1,2,3中的其中一个数字");
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        }
        System.out.println("您的选择为" + result[choice - 1]);  //显示用户的选择
        int random = 1 + (int) (Math.random() * 3);//Math.random() * 3)为0~3的随机浮点数   （int）强制类型转换为int型
        System.out.println("电脑的选择为" + result[random - 1]);
        int b = random - choice;
        switch (b) {
             case 2: System.out.println("你输了！");
                        break;
             case 1: System.out.println("你赢了！");
                        break;
             case 0: System.out.println("平局");
                        break;
             case -1: System.out.println("你输了！");
                        break;
              case -2:
                     System.out.println("你赢了！");
                        break;
              default:
                     System.out.println("请输入：1,2,3 中的一个数字");
        }
    }
}
