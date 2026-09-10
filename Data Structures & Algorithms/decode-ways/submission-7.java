class Solution {
    public int numDecodings(String s) {
        int prevLast = 0, prevSecondLast = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '0') {
                if(i == 0 || s.charAt(i-1) == '0' || s.charAt(i-1) > '2') {
                    return 0;
                }

                prevSecondLast = prevLast;
            }
            else if(i == 0) {
                prevLast++;
                prevSecondLast++;
            }
            else if(s.charAt(i-1) != '0' && s.charAt(i-1) <= '2' && (s.charAt(i-1) != '2' || s.charAt(i) <= '6') && (i+1 >= s.length() || s.charAt(i+1) != '0')) {
                int temp = prevLast;
                prevLast += prevSecondLast;
                prevSecondLast = temp;
            } else {
                prevSecondLast = prevLast;
            }
            
        }

        return prevLast;
    }
}
