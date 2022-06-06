package LeetcodeContests;

public class leetcodewc14 {
    class TextEditor {

        int cursor;
        StringBuilder sb;
        public TextEditor() {
            sb = new StringBuilder();
            cursor = 0;
        }
        
        public void addText(String text) {
            sb.append(text);
            cursor += text.length();
        }
        
        public int deleteText(int k) {
            int len = sb.substring(0, cursor+1).length();
            String sb1 = "";
            String deleted = "";
            if(sb.length() > cursor)
                sb1 = sb.substring(cursor+1, sb.length());
            cursor -= 10;
            if(len - k < 10) {
                deleted = sb.substring(len-k, len+1);
                String str = sb.substring(0, cursor+1);
                sb.append(str);
                sb.append(sb1);
            }
            else {
                deleted = sb.substring(len-k, len+1);
                String str = sb.substring(len - k - 10);
                sb.append(str);
                sb.append(sb1);
            }
            if(cursor < 0)
                cursor = 0;
            
            return deleted.length();
        }
        
        public String cursorLeft(int k) {
            cursor -= k;
            if(cursor < 0)
                cursor = 0;
            
            if(sb.substring(0, cursor+1).length() > 10) {
                return sb.substring(cursor-10, cursor+1);
            }
            return sb.substring(0, cursor+1);
        }
        
        public String cursorRight(int k) {
            cursor += k;
            if(cursor > sb.length()-1)
                cursor = sb.length()-1;
            if(sb.substring(0, cursor+1).length() > 10) {
                return sb.substring(cursor-10, cursor+1);
            }
            return sb.substring(0, cursor+1);
        }
    }

    public static void main(String[] args) {
        // String arr = new String[]{["TextEditor","addText","deleteText","addText","cursorRight","cursorLeft","deleteText","cursorLeft","cursorRight"]
        // [[],["leetcode"],[4],["practice"],[3],[8],[10],[2],[6]]};
    }
}
