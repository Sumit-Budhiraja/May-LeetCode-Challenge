class Solution {
    public int countPrimes(int n) {
        //Prepare a sieve (array) containing numbers from 1 to n
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }
        int p = 2;
        int count = 0;
        //Iterate over the sieve
        while(p < n) {
            //If the number at current index is not -1, its a prime number. Increment count by 1
            if(arr[p] != -1) {
                count++;
                
                //Mark all the numbers as -1 in the sieve which are divisible by current index and are greater than or equal to the square of it
                long sq = 1L * p * p;
                if(sq < arr.length) {
                    for(int i = (int)sq; i < arr.length; i = i + p) {
                        arr[i] = -1;
                    }
                }
                
            }
            p++;
        }
        
        //Return the count.
        return count;
    }
}
