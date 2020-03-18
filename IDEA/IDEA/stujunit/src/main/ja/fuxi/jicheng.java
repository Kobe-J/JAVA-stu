package ja.fuxi;

public class jicheng {
    //父类（爷爷辈）
  static class Father{
       protected String name;
       protected int age;
       public String getName() { return name; }
       public void setName(String name) { this.name = name; }
       public int getAge() { return age; }
       public void setAge(int age) { this.age = age; }
        public Father(String name, int age) { this.name=name;this.age=age; }
   }
   //既是子类也是父类(父亲辈)
   static class Person extends Father{
        protected String loc;
        public Person(String name,int age,String loc){ super(name,age);this.loc=loc; }
        public String getLoc() { return loc; }
        public void setLoc(String loc) { this.loc = loc; }
   }

   static class Son extends Person{
       public String grade;

       public String getGrade() { return grade; }
       public void setGrade(String grade) { this.grade = grade; }
       public Son(String name, int age, String loc, String grade) {
           super(name, age, loc);
           this.grade=grade;

       }
   }

    public static void main(String[] args) {
        Father ygj=new Father("姚国军",44);
        Person yxl=new Person("姚希龙",21,"北京");
        Son son=new Son("name",0,"loc","grade");
        System.out.println(ygj.getName()+" "+ygj.getAge());
        System.out.println(yxl.getName()+" "+yxl.getAge()+" "+yxl.getLoc());
        System.out.println(son.getName()+" "+son.getAge()+" "+son.getLoc()+" "+son.getGrade());
    }


}
