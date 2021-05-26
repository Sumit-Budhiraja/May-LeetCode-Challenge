class Solution {
    public int minPartitions(String n) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n.length() ; i++) {
            int ch = Character.getNumericValue(n.charAt(i));
            max = Math.max(ch,max);
        }
        return max;
    }
}