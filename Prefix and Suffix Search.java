class WordFilter {

    HashMap<String, Integer> map;
    public WordFilter(String[] words) {
        map = new HashMap();
        
        for(int i=0; i<words.length; i++) { // N
            String word = words[i];
            int n = word.length();
            String prefix = "";
            String suffix = "";
            String key = "";
            
            for(int j=n-1; j>=0; j--) { // K
                suffix = word.charAt(j) + suffix; 
                prefix = "";
                for(int k =0; k<n; k++) { // K
                    prefix = prefix + word.charAt(k);
                    key = suffix + "#" + prefix; // (M + L)
                    if(map.containsKey(key)) {
                        if(words[map.get(key)].length() <= n) {
                            map.put(key, i);
                        }
                    } else {
                        map.put(key, i);
                    }
                }
            }
        }
    }
    
    public int f(String prefix, String suffix) {
        Integer ans = map.get(suffix+"#"+prefix);
        return ans == null ? -1 : ans;
    }
}