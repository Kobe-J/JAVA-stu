package LIkou;

public class LIkou {
    public static void main(String[] args) {
        //jiafa(new int[]{2,7,11,15},9);
        int a =1;
        int b =2;
        int c=3;
        System.out.println(a<c?b:c);

        }
        public static void jiafa(int[] a,int b){
            //a= new int[]{0, 7, 8, 2};
            int i;
            //b=9;
            for (i = 0; i < a.length-1; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j] == b - a[i]) {
                        System.out.println(i);
                        System.out.println(j);
                    }
                }
            }
        }
   }
