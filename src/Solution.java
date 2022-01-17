class Solution {

//    int count = 0;
//    public static int countHighlyProfitableMonth(int[] stockPrices, int k) {
//        for(int i=0; i<stockPrices.length; i++) {
//            boolean flag = true;
//            for(int j=i+1; j<stockPrices.length && j<i+k; j++) {
//                if(stockPrices[j] <= stockPrices[j-1]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if(flag)
//                count++;
//        }
//        return count;
//    }

    public static void main(String[] args) {
        int[] stockPrices = {5,3,5,7,8};
        int k = 3;
        int count = 0;
//        System.out.println(countHighlyProfitableMonth(nums, 3));
        for(int i=0; i<stockPrices.length-2; i++) {
            boolean flag = true;
            for(int j=i+1; j<stockPrices.length && j<i+k; j++) {
                if(stockPrices[j] <= stockPrices[j-1]) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                count++;
        }
        System.out.println(count);;
    }
}