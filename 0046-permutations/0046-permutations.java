class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        solve(nums, used, output, ans);
        return ans;
    }

    public void solve(int[] nums, boolean[] used, List<Integer> output, List<List<Integer>> ans) {
        if(output.size() == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }

            used[i] = true;
            
            output.add(nums[i]);
            solve(nums, used, output, ans);

            output.remove(output.size() - 1);
            used[i] = false;
        }
    }
}