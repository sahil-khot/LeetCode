class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Character[] arr = new Character[s.length()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i);
        } 

        Arrays.sort(arr, (a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);

            if(fa != fb) {
                return fb - fa;
            }
            return a - b;
        });

        StringBuilder ans = new StringBuilder();
        for(char ch : arr) {
            ans.append(ch);
        }
        return ans.toString();
    }
}