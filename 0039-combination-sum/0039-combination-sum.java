class Solution {

    public static void solve(int[] candidates, int target, int i, List<Integer> output, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList(output));
            return;
        }

        if(i >= candidates.length) {
            return;
        }

        if(target < 0) {
            return;
        }

        output.add(candidates[i]);
        solve(candidates, target - candidates[i], i, output, ans);

        output.remove(output.size() - 1);
        solve(candidates, target, i + 1, output, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        int i = 0;
        solve(candidates, target, i, output, ans);
        return ans;
    }
}