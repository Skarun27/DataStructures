package Google.Hard;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        
        boolean flag = false;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                flag = true;
            }
            if(nums[i] < 1 || nums[i] > n)
                nums[i] = 1;
        }
        if(!flag) return 1;
        
        for(int i=0; i<n; i++) {
            if(Math.abs(nums[i]) == n) {
                nums[0] = nums[0] * (-1);
                continue;
            }
            if(nums[Math.abs(nums[i])] > 0)
                nums[Math.abs(nums[i])] = nums[Math.abs(nums[i])] * (-1);
        }
        
        for(int i=1; i<n; i++) {
            if(nums[i] > 0)
                return i;
        }
        if(nums[0] < 0)
            return n+1;
        
        else return n;
    }
}
