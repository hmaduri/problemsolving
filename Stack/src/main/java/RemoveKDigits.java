/**
 * leetcode problem 402
 */
import java.util.Stack;

public class RemoveKDigits {

    private int Int(char ch) {
        return ch - '0';
    }

    public String removeKdigits(String num, int k) {
        Stack<Integer> stk = new Stack<Integer>();
        for (char ch : num.toCharArray()) {
            while (k > 0 && !stk.isEmpty() && stk.peek() > Int(ch)) {
                stk.pop();
                k--;
            }
            stk.push(Int(ch));
        }

        String result = "";
        while (!stk.isEmpty() && k > 0) {
            stk.pop();
            k--;
        }

        while(!stk.isEmpty()) {
            result = stk.pop() + result;
        }
        return massage(result);
    }

    private String ltrim(String result, char toTrim) {
        String trimmed = "";
        boolean first = true;
        for (char ch : result.toCharArray()) {
            if (first && ch == toTrim) continue;
            first = false;
            trimmed += ch;
        }
        return trimmed;
    }

    private String massage(String result) {
        String trimmed = ltrim(result, '0');
        return trimmed == "" ? "0" : trimmed;
    }
}
