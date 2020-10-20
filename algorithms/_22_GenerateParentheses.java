package algorithms;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 *
 * @author wuxiaobiao
 * @date 2020-09-27 : 17:09
 */
public class _22_GenerateParentheses {



    Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        _22_GenerateParentheses parentheses = new _22_GenerateParentheses();
        List<String> a = parentheses.generateParenthesis(4);
        List<String> b = parentheses.generateParenthesis(2);
        List<String> c = parentheses.generateParenthesis(3);

    }


    public List<String> generateParenthesis(int n) {
        return new ArrayList<>(paritionGenerate(n));
    }


    public Set<String> paritionGenerate(int n) {

        if (n == 1) {
            return generate("");
        }
        Set<String> result = new HashSet<>();
        Set<String> strings = paritionGenerate(n-1);
        for (String s: strings) {
            result.addAll(generate(s));
        }
        return result;
    }

    Set<String> generate(String partern) {

        Set<String> res = new HashSet<>();
        res.add(partern + "()");
        res.add("()" + partern);
        res.add("(" + partern + ")");
        return res;
    }


}
