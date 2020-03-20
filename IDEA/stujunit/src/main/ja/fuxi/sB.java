package ja.fuxi;

public class sB {
    public static void main(String[] args) {
        var sb = new StringBuilder(1024);
        sb.append("Mr ")
            .append("Bob")
            .append("!")
            .insert(0, "Hello, ");
        String s=sb.toString();
        System.out.println(sb+"    "+s);
        System.out.println(Integer.valueOf(s));
    }
}
