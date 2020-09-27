package algorithms;


import java.util.*;

/**
 *
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-27 : 09:42
 */
public class _17_LetterCombinationsOfAPhoneNumber {


    /***
     *
     * Runtime: 1 ms, faster than 83.85% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 39.1 MB, less than 65.39% of Java online submissions for Letter Combinations of a Phone Number.
     *
     *
     * @param args
     */

    public static void main(String[] args) {

        _17_LetterCombinationsOfAPhoneNumber number = new _17_LetterCombinationsOfAPhoneNumber();
        List<String> a = number.letterCombinations("23");
        List<String> b = number.letterCombinations("34");
        List<String> c = number.letterCombinations("45");

    }


    List<String> result = new ArrayList<>();

    Map<Character, String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wzyz");
    }};

    public List<String> letterCombinations(String digits) {

        if (digits.length() > 0) {
            partitionLetterCombinations("", digits);
        }

        return result;
    }


    public void partitionLetterCombinations(String pres, String digits) {

        if (digits.length() == 0) {
            result.add(pres);
        } else {
            Character char1 = digits.charAt(0);
            String values = map.get(char1);
            for (int i=0;i<values.length();i++) {
                Character character = values.charAt(i);
                partitionLetterCombinations(pres + character, digits.substring(1));
            }
        }

    }

}
