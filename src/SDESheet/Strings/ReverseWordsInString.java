package SDESheet.Strings;

public class ReverseWordsInString {
    public static String reverseWords(String s) {

        String[] resultStr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=resultStr.length-1; i>=0; i--) {
            if(resultStr[i].length() != 0)
                sb.append(" ").append(resultStr[i]);
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is pink"));
    }
}
