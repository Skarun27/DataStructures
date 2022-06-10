package InterviewQuestions;

public class Google1 {
    // Java to find largest number with
// given conditions.

    // function to find the largest number
    // with given conditions.
    static int largestNum(int num)
    {
        int max_digit = -1;
        int max_digit_indx = -1;
        int l_indx = -1;
        int r_indx = 1;

        // converting the number to string
        String num_in_str = String.valueOf(num);
        for (int i = num_in_str.length() - 1; i >= 0; i--) {
            // current digit is the largest by far
            if (num_in_str.charAt(i) > max_digit) {
                max_digit = num_in_str.charAt(i);
                max_digit_indx = i;
                continue;
            }

            // best digit for swap if there is no more
            // such situation on the left side
            if (num_in_str.charAt(i) < max_digit) {
                l_indx = i;
                r_indx = max_digit_indx;
            }
        }
        // check for is number already in order
        if (l_indx == -1)
            return num;

        num_in_str = reverse(num_in_str, l_indx, r_indx);

        return Integer.parseInt(num_in_str);
    }
    static String reverse(String arr, int i, int j)
    {
        char temp[] = arr.toCharArray();
        while (i < j){
            char c = temp[i];
            temp[i] = temp[j];
            temp[j] = c;
            i++;
            j--;
        }

        return String.valueOf(temp);
    }

    // Driver code
    public static void main(String[] args)
    {
        int num = 1080;
        System.out.println(largestNum(num));
        num = 5340;
        System.out.println(largestNum(num));
        num = 2043;
        System.out.println(largestNum(num));
        num = 620;
        System.out.println(largestNum(num));
        num = 10880;
        System.out.println(largestNum(num));
        num = 1356;
        System.out.println(largestNum(num));
    }  
}
