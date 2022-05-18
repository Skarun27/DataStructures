package Practice.Recursion;

public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        s = reverse(s);
        System.out.println(s);
    }

    public static String reverse(String s) {
        if(s.equals(""))
            return "";

        return reverse(s.substring(1)) + s.charAt(0);
    }
}
