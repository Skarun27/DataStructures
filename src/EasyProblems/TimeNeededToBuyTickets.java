package EasyProblems;

public class TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int ans=0;
        for(int i=0;i<tickets.length;++i)
        {
            if(i<=k)
            {
                ans+=Math.min(tickets[i],tickets[k]);
            }
            else{
                ans+=Math.min(tickets[i],tickets[k]-1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,1,1};
        System.out.println(timeRequiredToBuy(arr, 0));
    }
}
