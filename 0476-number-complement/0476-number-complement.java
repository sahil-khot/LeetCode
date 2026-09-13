class Solution {
    public int findComplement(int num) {
        StringBuilder binary = new StringBuilder();
        while(num > 0) {
            int bit = num % 2;
            binary.append(bit == 1 ? 0 : 1);
            num /= 2;
        }
        binary = binary.reverse();

        int complement = 0;
        int power = 0;
        for(int i = binary.length() - 1; i >= 0; i--) {
            int bit = binary.charAt(i) - '0';
            if(bit == 1) {
                complement += Math.pow(2, power);
            }
            power++;
        }
        return complement;
    }
}