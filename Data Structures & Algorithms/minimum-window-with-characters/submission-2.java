public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFreq = new HashMap<>();
        char[] tArr = t.toCharArray();
        char[] sArr = s.toCharArray();
        for(int i=0; i<tArr.length; i++) {
            tFreq.put(tArr[i], tFreq.getOrDefault(tArr[i], 0) + 1);
        }
        int remainingCharacters = tArr.length;
        int shortest = 0;
        String shortestString = "";

        int left = 0, right = 0;
        while(left < s.length() && !tFreq.containsKey(sArr[left])) {
            left++;
        }
        right = left;

        while(left <= right && right < s.length()) {
            if(!tFreq.containsKey(sArr[right])) {
                right++;
            }

            else {
                tFreq.put(sArr[right], tFreq.get(sArr[right]) - 1);
                if(tFreq.get(sArr[right]) >= 0) {
                    remainingCharacters--;

                }
                right++;

                if(remainingCharacters == 0) {
                    shortestString = shortestString.isEmpty() || shortestString.length() > (right - left) ? s.substring(left, right) : shortestString;

                    tFreq.put(sArr[left], tFreq.get(sArr[left]) + 1);
                    if(tFreq.get(sArr[left]) > 0) {
                        remainingCharacters++;
                    }
                    left++;

                    while(left < s.length() && (!tFreq.containsKey(sArr[left]) || remainingCharacters == 0)) {
                        if(remainingCharacters == 0 && tFreq.containsKey(sArr[left])) {
                            shortestString = shortestString.isEmpty() || shortestString.length() > (right - left) ? s.substring(left, right) : shortestString;
                            tFreq.put(sArr[left], tFreq.get(sArr[left]) + 1);
                            if(tFreq.get(sArr[left]) > 0) {
                                remainingCharacters++;
                            }
                        }

                        left++;
                    }

                }
            }
        }

        return shortestString;
    }
}
