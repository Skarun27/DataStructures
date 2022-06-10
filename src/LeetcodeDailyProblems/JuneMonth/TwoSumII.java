package LeetcodeDailyProblems.JuneMonth;

public class TwoSumII {
    
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j= numbers.length -1;
        while( i <j)
        {
            int m= i+ (j -i)/2;
            int sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[] {i+1, j+1};
            if(sum >=target){
                if(numbers[i] + numbers[m] > target)
                    j = m-1;
                else 
                    j--;
            }
            else
            {
                if(numbers[m] + numbers[j] < target)
                    i = m+1;
                else
                    i++;
            }
            
        }
        return null;
    }
}
