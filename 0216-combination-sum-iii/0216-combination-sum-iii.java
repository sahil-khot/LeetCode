class Solution {
    static void solve(int[] candidates, int target, int i, List<List<Integer>> ans, List<Integer> output, int count,
            int k) {

        if (count > k) {
            return;
        }

        if (count == k && target == 0) {
            ans.add(new ArrayList(output));
            return;
        }

        if (i >= candidates.length) {
            return;
        }

        if (target < 0) {
            return;
        }

        output.add(candidates[i]);
        solve(candidates, target - candidates[i], i + 1, ans, output, count + 1, k);

        // while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
        //     i++;
        // }

        output.remove(output.size() - 1);
        solve(candidates, target, i + 1, ans, output, count, k);

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int i = 0;
        int[] candidates = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int target = n;
        int count = 0;

        solve(candidates, target, i, ans, output, count, k);

        return ans;
    }
}