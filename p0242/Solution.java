package p0242;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("anagram", "nagaram"));
        System.out.println(solution.isAnagram("rat", "car"));
    }

    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> occurrences = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (occurrences.containsKey(ch)) {
                occurrences.put(ch, occurrences.get(ch) + 1);
            } else {
                occurrences.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (!occurrences.containsKey(ch)) {
                return false;
            }

            var occ = occurrences.get(ch);
            if (occ < 0) {
                return false;
            }
            occurrences.put(ch, occ - 1);
        }

        for (var occ : occurrences.values()) {
            if (occ != 0) {
                return false;
            }
        }

        return true;
    }

    public boolean isAnagramV1(String s, String t) {
        int[] occurrences = new int[26];

        for (int i = 0; i < s.length(); i++) {
            occurrences[s.charAt(i) - 97] += 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 97;
            if (occurrences[index] == 0) {
                return false;
            }

            occurrences[index] -= 1;
        }

        for (int i = 0; i < 25; i++) {
            if (occurrences[i] != 0) {
                return false;
            }
        }

        return true;
    }
}