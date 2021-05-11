class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] begin = new int[k + 1]; // begin[i] is the number of points we can obtain if we pick i cards in the beginning
        int[] end = new int[k + 1]; // end[i] is the number of points we can obtain if we pick i cards in the end
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            begin[i+1] = begin[i] + cardPoints[i];
            end[i+1] = end[i] + cardPoints[n-i-1];
        }
        int ans = 0;
        for (int i = 0; i <= k; i++)
            ans = Math.max(ans, begin[i] + end[k-i]);
        return ans;
    }
}