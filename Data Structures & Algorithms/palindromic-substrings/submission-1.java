class Solution {
    public int countSubstrings(String s) {
        if(s.length() == 1) return 1;
        
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0; i<dp.length; i++) {
            for(int j=i; j<i+1; j++) {
                dp[i][j] = 1;
            }
        }

        int totalPalindromes = s.length();

        for(int i=1; i<s.length(); i++) {
            for(int j=0; (i+j)<s.length(); j++) {
                if(s.charAt(j) == s.charAt(j+i) && (i <= 2 || dp[j+1][j+i-1] == 1)) {
                    dp[j][j+i] = 1;
                    totalPalindromes++;
                }
            }
        }

        return totalPalindromes;
    }
}
