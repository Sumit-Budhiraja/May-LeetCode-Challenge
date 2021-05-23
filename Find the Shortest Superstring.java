class Solution {
    public String shortestSuperstring(String[] words) {
        
        HashMap<String,String> dp = new HashMap();
        int mask = 0;
        for(int i =0;i<words.length;i++) mask = mask|(1<<i);
        return helper(dp,mask,words,"");
        
    }
    
    public String helper(HashMap<String,String> dp , int mask , String[] words , String start){
        
         if(mask==0) return start; // base case
          
         String key = start+"#"+mask;
         if(dp.get(key)!=null) return dp.get(key); // memoization 
         
         String result = null; // result for current subproblem 
        
         for(int i =0;i<words.length;i++){
             
             if(((mask>>i)&1)==1){ // if current spot is available , bit on denotes spot available bit off denotes spot unavailable
                 int nmask = mask&~(1<<i); // turn off the bit corresponding to this word 
                 String ros = helper(dp,nmask,words,words[i]); // get shortest superstring starting with words[i]
                 String pans = append(start,ros); // kind of a blackbox which generates possible superstring
                 if(result==null||pans.length()<result.length()) result = pans;
             }
             
         }
         
         dp.put(key,result);
         return result;
    }
    
    public String append(String a , String b){ // black magic , only the brave shall understand this !
        for(int i = Math.max(1,a.length()-b.length());i<a.length();i++){
            boolean check = true;
            for(int j = i; j<a.length();j++){
                if(a.charAt(j)!=b.charAt(j-i)) check = false;
            }
            if(check) return a.substring(0,i)+b;
        }
        return a + b;
        // okay I do understand it , I understand that this was made by looking at edge cases , but frankly I don't see myself coming up with it (based on my current level :p) 
    }
    
}