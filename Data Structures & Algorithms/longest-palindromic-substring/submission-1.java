class Solution {
    public String longestPalindrome(String s) {
        char[] sArr = s.toCharArray();

        if(sArr.length == 1) return s;

        if(sArr.length == 2) return  sArr[0] == sArr[1] ? s : s.substring(0,1);

        int[] resultIndex = new int[2];
        int maxResultLength = 0;
        for(int i=1; i<sArr.length - 1; i++) {
            int left = i-1, right = i+1;
            int center = sArr[i];
            while(true) {
                while(left >= 0 && sArr[left] == sArr[left+1]) {
                    left--;
                }

                while(right < sArr.length && sArr[right] == sArr[right-1]) {
                    right++;
                }

                while(left >= 0 && right < sArr.length && sArr[left] == sArr[right]) {
                    left--;
                    right++;
                }

                if(maxResultLength < (right - left + 1)) {
                    maxResultLength = right - left + 1;
                    resultIndex[0] = left + 1;
                    resultIndex[1] = right - 1;
                }

                break;
            }
        }

        return s.substring(resultIndex[0], resultIndex[1] + 1);
    }
}
