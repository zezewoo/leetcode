package algorithms;


import java.util.*;

/**
 * @author wxb
 * @date 2020-10-26 : 13:43
 */
public class _30_SubstringWithConcatenationOfAllWords {


    public static void main(String[] args) {

        _30_SubstringWithConcatenationOfAllWords withConcatenationOfAllWords = new _30_SubstringWithConcatenationOfAllWords();

        String[] strings = {"foo","bar"};

        String a = "";
        String b = "";
        a.contains(b);


        List<Integer> c = withConcatenationOfAllWords.findSubstringA("barfoothefoobarman", strings);

    }



    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        List<String> strings = composeStr(Arrays.asList(words));

        for (String str : strings) {
            List<Integer> subs = subPart(s, str);
            result.addAll(subs);
        }
        return result;
    }




    public List<Integer> findSubstringA(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        for (int i=0;i<words.length;i++) {
            List<String> subString = Arrays.asList(words);
            subString.remove(i);
            int in = s.indexOf(words[i]);
        }
        return result;
    }




    public List<String> composeStr(List<String> strings) {

        if (strings.size() == 1) {
            return strings;
        }

        Set<String> results = new HashSet<>();
        for (int i=0;i<strings.size();i++) {

            List<String> subString = new ArrayList<>(strings);
            subString.remove(i);

            List<String> subResults = composeStr(subString);
            for (String sub: subResults) {
                String result = strings.get(i) + sub;
                results.add(result);
            }
        }
        return new ArrayList<>(results);
    }



    public List<Integer> subPart(String s, String word) {

        List<Integer> result = new ArrayList<>();

        int i=0;
        while(s.length() - i >= word.length()) {

            int j = 0;
            int k = i;
            while (j < word.length()) {

                if (s.charAt(k) != word.charAt(j)) {
                    break;
                }
                k ++;
                j ++;
            }

            if (j == word.length()) {
                result.add(i);
            }
            i ++;
        }

        return result;
    }

}
