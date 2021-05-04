class Solution {
    public boolean checkPossibility(int[] nums) {
	    // array with 2 or less element can always be modify to non-decreasing array
        if (nums.length < 3) { return true;}
		// try to decrease one number
        int min = nums[nums.length - 1];
        int count = 0;
        for (int i = nums.length -2 ; i >= 0 ; i--) {
            if (nums[i] < min) {
                min = nums[i];
            } else if ( nums[i] > min) {
			    // spot a number to be decreased when nums[i] < min.
                count++;
				// no need to check if more than one is found
                if (count > 1) { break;}
            }
        }
		// if only one or less is found, it is non-decreasing array by decreasing at most one element.
        if (count < 2) { return true; }
		// try to increase one number
        int max = nums[0];
        count = 0;
        for (int i = 1 ; i < nums.length ; i++) {
            if (nums[i] > max) {
                max = nums[i];
            } else if ( nums[i] < max) {
			    // spot a number to be increased when nums[i] > max.
                count++;
                if (count > 1) { return false; }
            }
        }
        
        return true;
    }
}