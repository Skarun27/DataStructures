package EasyProblems;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int res = 0;
        for(int i=0; i<n; i++) {
            res = res * 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "CBA";
        System.out.println(titleToNumber(str));
    }
}
