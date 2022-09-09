package Google.Easy;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder builder = new StringBuilder();
        int groupLength = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur != '-') {
                if (groupLength == k) {
                    builder.append('-');
                    groupLength = 0;
                }
                groupLength++;
                builder.append(Character.toUpperCase(cur));
            }
        }
        
        return builder.reverse().toString();
    }
}
