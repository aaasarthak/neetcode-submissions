class Solution {
    public boolean checkInclusion(String s1, String s2) {
        var s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);
        var s2CharArray = s2.toCharArray();

        int left = 0;
        int right = left + s1CharArray.length;
        while(right <= s2CharArray.length) {
            var substring = s2.substring(left, right);
            var substringCharArray = substring.toCharArray();
            Arrays.sort(substringCharArray);
            if(Arrays.equals(substringCharArray, s1CharArray)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }
}
