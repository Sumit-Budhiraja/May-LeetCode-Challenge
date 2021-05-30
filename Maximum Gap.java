class Solution {
    public int maximumGap(int[] nums) {
          if(nums.length < 2)
        return 0;
    Arrays.sort(nums);
    int res =0;
    int temp;
    for(int i =0;i<nums.length-1;i++)
    {
        temp = nums[i+1]-nums[i];
        res = Math.max(temp,res);
    }
    return res;

    }
}