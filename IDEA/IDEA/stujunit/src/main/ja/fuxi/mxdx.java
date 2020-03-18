package ja.fuxi;

public class mxdx {
        public static void main(String[] args) {
            Person ming = new Person();
            String ys= "姚希龙";
            ming.setName(ys); // 对字段name赋值
            ys="王珊";
            ming.setName(ys);
            ming.setAge(21);// 对字段age赋值
            System.out.println("姓名："+ming.getName()+"\n"+"年龄:"+ming.getAge());

            Person yxl = new Person();
            System.out.println(yxl.getName()+"\n"+yxl.getAge());

        }


     static class Person {
        private String name;
        private int age;

         public String getName() {
             return this.name;
         }

         public void setName(String name) {
             this.name = name;
         }

         public int getAge() {
             return age;
         }

         public void setAge(int age) {
             this.age = age;
         }
         public void Person(String name,int age){//构造方法
                    this.name=name;
                    this.age=age;

         }
     }

}
