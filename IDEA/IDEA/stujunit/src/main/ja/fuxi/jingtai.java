package ja.fuxi;

public class jingtai {

        public static void main(String[] args) {
            Person ming = new Person("Xiao Ming", 12);
            Person hong = new Person("Xiao Hong", 15);
            ming.number = 88;
            System.out.println(hong.number);
            System.out.println(Person.getCount());
            hong.number = 99;
            System.out.println(ming.number);
            System.out.println(Person.getCount());
            System.out.println(Person.getCount());
        }
    static class Person {
        public String name;
        public int age;
        public static int cout;

        public static int number;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public  static int getCount(){
            return cout++;
        }
    }

}
