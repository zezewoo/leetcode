package com.leetcode.algorithms.start.resolution;


public class LongestSubstringWithoutRepeatingCharacters {



    public int lengthOfLongestSubstring(String s) {

        int k = 0, j = 1, n = 0;

        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Integer[] array = new Integer[256];

        for (int i=0;i<s.length();i++) {

            int val = s.charAt(i);

            if (array[val] == null) {
                k ++;
                array[val] = val;

                if (k > j) {
                    j = k;
                }

            } else {
                array = new Integer[256];
                k = 0;
                i = n++;
            }


        }

        return j;
    }

    public static void main(String[] args) {

        int i = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb");
    }


}
