package Google.Easy;

import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int i=0; i<emails.length; i++) {
            String[] emailParsed = emails[i].split("@");
            String[] beforeAdd = emailParsed[0].split("\\+");
            String parseDots = beforeAdd[0].replace(".", "");
            String finalEmail = parseDots + "@" + emailParsed[1];
            set.add(finalEmail);
        }
        return set.size();
    }
}
