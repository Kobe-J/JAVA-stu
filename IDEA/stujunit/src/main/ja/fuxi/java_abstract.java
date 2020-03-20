package ja.fuxi;

public  class  java_abstract{
    public static void main(String[] args) {
        Father[] fs=new Father[]{new Son(7000)};
        double total=0;
        for ( Father father : fs ){
            total=total+father.structure();
        }
        System.out.println(total);
    }
     static abstract class Father{
         protected double Tax;
         public Father(double Tax){
             this.Tax=Tax;
         }
         public abstract double structure();
     }

        static class Son extends Father{
         public Son(double Tax){
             super(Tax);
         }
         @Override
         public  double structure(){
                if (Tax <= 5000){
                    return 0;
                }else {
                    return (Tax-5000)*0.2;
                }
          }
     }
}
