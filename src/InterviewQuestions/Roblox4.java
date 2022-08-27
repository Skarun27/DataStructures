package InterviewQuestions;

public class Roblox4 {
    
    public static int solution(int[] object, int radius) {

        int end = object[object.length-1] - radius;
        int start = object[0] - radius;
        int cordinate = 0;
        int maxObjects = 0;

        for(int i=start; i<=end; i++) {
            int upperbound = i + radius;
            int lowerbound = i - radius;
            int count = countInRange(object, lowerbound, upperbound);
            if(maxObjects < count) {
                cordinate = i;
                maxObjects = count;
            }
        }
        return cordinate;
    }

    static int lowerIndex(int arr[], int n, int x)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] >= x)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
     
    // function to find last index <= y
    static int upperIndex(int arr[], int n, int y)
    {
        int l = 0, h = n - 1;
        while (l <= h)
        {
            int mid = (l + h) / 2;
            if (arr[mid] <= y)
                l = mid + 1;
            else
                h = mid - 1;
        }
        return h;
    }
     
    // function to count elements within given range
    static int countInRange(int arr[], int x, int y)
    {
        // initialize result
        int count = 0;
        int n = arr.length;
        count = upperIndex(arr, n, y) -
                lowerIndex(arr, n, x) + 1;
        return count;
    }

    public static void main(String[] args) {
        
        int[] arr = {-1000000000};
        System.out.println(solution(arr, 100000));
    }
}
