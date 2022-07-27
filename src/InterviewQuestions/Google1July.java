package InterviewQuestions;

public class Google1July {
    
    public static int solution(String text) {
        
        char[] arr = {'a', 'b', 'c'};
        int i = 0;
        int pointer = 0;
        int insertionCount = 0;
        int n = text.length();
        
        while(i < n) {
            if(text.charAt(i) == arr[pointer])
                i++;
            else
                insertionCount++;
            pointer = (pointer + 1) % 3;
        }
        return insertionCount;
    }

    public static void main(String[] args) {
        String text = "acbacA";
        System.out.println(solution(text));
    }
}
