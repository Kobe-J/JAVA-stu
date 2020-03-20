package ja.fuxi;

public class ffcz {
    public static void main(String[] args) {
        String s = "Test string";
        int n1 = s.indexOf('t');
        int n2 = s.indexOf("st");
        int n3 = s.indexOf("st", 4);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        Person ming = new Person();
        Person hong = new Person();
        ming.setName("yxl");
        // 给Person增加重载方法setName(String, String):
        hong.setName("yao", "xiLong");
        System.out.println(ming.getName());
        System.out.println(hong.getName());
    }
    static class Person{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public void setName(String name1,String name2) {
            this.name = name1+name2;
        }
    }
}
