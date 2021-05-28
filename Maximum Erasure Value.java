public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int sum = 0;

        Set<Integer> unique = new HashSet<>();
        int left = 0;
        int right = 0;
        int length = nums.length;
        while (right < length) {
            int num = nums[right];
            if (!unique.contains(num)) {
                sum += num;
                unique.add(num);
                maxSum = Math.max(maxSum, sum);
                ++right;
            } else {
                while (left < right && unique.contains(num)) {
                    int erase = nums[left];
                    unique.remove(erase);
                    sum -= erase;
                    ++left;
                }
            }
        }

        return maxSum;
    }
}