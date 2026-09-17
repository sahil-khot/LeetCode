class Solution {
    public String longestPalindrome(String s) {

        if(s.length() < 2) {
            return s;
        }
        if(isPalindrome(s)) {
            return s;
        }
        int maxLength = 0;
        String maxPalindrome = s.substring(0, 1);
        for(int i = 0; i < s.length() - 1; i++) {
            for(int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                if(isPalindrome(str) && str.length() > maxPalindrome.length()) {
                    maxPalindrome = str;
                    maxLength = str.length();
                }
            }
        }

        return maxPalindrome;
    }

    public boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}