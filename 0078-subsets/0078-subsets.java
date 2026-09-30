class Solution {

    public static void getSubsets(int[] nums, int i, List<Integer> output, List<List<Integer>> ans) {

        if(i >= nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        output.add(nums[i]);
        getSubsets(nums, i + 1, output, ans);

        output.remove(output.size() - 1);
        getSubsets(nums, i + 1, output, ans);
    }


    public List<List<Integer>> subsets(int[] nums) {
        int i = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        getSubsets(nums, i, output, ans);

        return ans;
    }
}