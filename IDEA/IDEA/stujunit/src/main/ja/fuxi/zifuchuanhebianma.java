package ja.fuxi;

public class zifuchuanhebianma {
    public static void main(String[] args) {
        String s = "Hello";
        String s1= "hello";
        System.out.println(s);
        s = s.toUpperCase();//把字符串变成大写
        s=s.toLowerCase();//把字符串变成小写
        System.out.println(s);
        System.out.println(s.equalsIgnoreCase(s1));//忽略大小写比较
        // 是否包含子串:
        System.out.println("Hello".contains("ll")); // true
        "Hello".indexOf("l"); // 2  l在hello中的出现的起始的下标位置
        "Hello".lastIndexOf("l"); // 3 l在hello中的出现的最后的的下标位置
        "Hello".startsWith("He"); // true  是否以He开头
        "Hello".endsWith("lo"); // true    是否以lo结尾

        //提取子串的例子
        System.out.println("Hello".substring(1));; // "ello" 字符串截取 下标为1以及以后的所有
        System.out.println("Hello".substring(0,5)); //"hello"  截取 下标为0-5
        //使用trim()方法可以移除字符串首尾空白字符。空白字符包括空格，\t，\r，\n：
        System.out.println("  \tHello\r\n ");//"  	Hello"
        System.out.println("  \tHello\r\n ".trim()); // "Hello"  注意：trim()并没有改变字符串的内容，而是返回了一个新字符串。

        //另一个strip()方法也可以移除字符串首尾空白字符。它和trim()不同的是，类似中文的空格字符\u3000也会被移除：
        System.out.println("\u3000Hello\u3000".strip()); // "Hello"
        System.out.println(" Hello ".stripLeading()); // "Hello "
        System.out.println(" Hello ".stripTrailing()); // " Hello"
        //String还提供了isEmpty()和isBlank()来判断字符串是否为空和空白字符串：
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        //要在字符串中替换子串，有两种方法。一种是根据字符或字符串替换：
        String a = "hello";
        a.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        a.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
       //另一种是通过正则表达式替换：
        String b = "A,,B;C ,D";
        b.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"
       //上面的代码通过正则表达式，把匹配的子串统一替换为","。


       //分割字符串
       // 要分割字符串，使用split()方法，并且传入的也是正则表达式：
        String d = "A,B,C,D";
        String[] dd = d.split("\\,"); // {"A", "B", "C", "D"}



       // 拼接字符串
       // 拼接字符串使用静态方法join()，它用指定的字符串连接字符串数组：
        String[] arr = {"A", "B", "C"};
        //String f = String.join("***", arr); // "A***B***C"


       // 强制类型转换
       // 要把任意基本类型或引用类型转换为字符串，可以使用静态方法valueOf()。这是一个重载方法，编译器会根据参数自动选择合适的方法：
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c


       // 要把字符串转换为其他类型，就需要根据情况。例如，把字符串转换为int类型：
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255


        //把字符串转换为boolean类型：
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false


       // 要特别注意，Integer有个getInteger(String)方法，它不是将字符串转换为int，而是把该字符串对应的系统变量转换为Integer：
        Integer.getInteger("java.version"); // 版本号，11


        //转换为char[]
       // String和char[]类型可以互相转换，方法是：
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String c = new String(cs); // char[] -> String
        //如果修改了char[]数组，String并不会改变：
        System.out.println(c);
        cs[0] = 'X';
        System.out.println(c);
    }
}
