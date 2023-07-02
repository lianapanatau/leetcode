package p0049;

import java.util.*;


class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
        System.out.println(solution.groupAnagrams(new String[]{"ddddddddddg", "dgggggggggg"}));
        System.out.println(solution.groupAnagrams(new String[]{"ac", "ca", "cd", "d"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        var result = new HashMap<Integer, List<String>>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            int key = Arrays.hashCode(chars);
            if (result.containsKey(key)) {
                result.get(key).add(str);
            } else {
                var list = new ArrayList<String>();
                list.add(str);
                result.put(key, list);
            }
        }

        return new ArrayList<>(result.values());
    }
}