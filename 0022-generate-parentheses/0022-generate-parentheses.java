class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve("", ans, 0, 0, n);
        return ans;
    }

    public static void solve(String s, List<String> ans, int open, int close, int n) {
        if(s.length() == 2 * n) {
            ans.add(s);
            return;
        }

        if(open < n) {
            solve(s + '(', ans, open + 1, close, n);
        }

        if(close < open) {
            solve(s + ')', ans, open, close + 1, n);
        }
    }
}