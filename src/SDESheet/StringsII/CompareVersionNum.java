package SDESheet.StringsII;

public class CompareVersionNum {
    public static int compareVersion(String version1, String version2) {

        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i=0;

        while(i<n1 && i<n2) {
            if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
                return 1;
            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]))
                return -1;
            i++;
        }

        while(i < n1) {
            if(Integer.parseInt(arr1[i]) > 0)
                return 1;
            i++;
        }

        while(i < n2) {
            if(Integer.parseInt(arr2[i]) > 0)
                return -1;
            i++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01.001", "1.001"));
    }
}
