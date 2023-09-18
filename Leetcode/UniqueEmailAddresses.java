// url: https://leetcode.com/problems/unique-email-addresses/

class Solution {

    private String format(String email) {
        String[] em = email.split("\\@"), locName = em[0].split("\\+");
        String formatted = locName[0].replaceAll("\\.", "");
        return formatted + "@" + em[1];
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email: emails) set.add(format(email));
        return set.size();
    }
}
