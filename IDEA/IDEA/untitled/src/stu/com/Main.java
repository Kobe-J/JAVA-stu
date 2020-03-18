package stu.com;

public class Main {

    public static void main(String[] args) {
    }
    public static  void dayin(int a,int b,int c,int d,int e){
        for ( a = 0; a < 5; a++) {
            System.out.print("*");
            if (a == 4) {
                System.out.println();
                for ( b = 0; b < 4; b++) {
                    System.out.print("*");
                    if (b == 3) {
                        System.out.println();
                        for (c = 0; c < 3; c++) {
                            System.out.print("*");
                            if (c == 2) {
                                System.out.println();
                                for ( d = 0; d < 2; d++) {
                                    System.out.print("*");
                                    if (d == 1) {
                                        System.out.println();
                                        for (e = 0; e < 1; e++) {
                                            System.out.print("*");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

