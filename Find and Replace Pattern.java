class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        String p = normalize(pattern);
        for (String word : words)
            if (p.equals(normalize(word)))
                ans.add(word);
        return ans;
    }
    String normalize(String str) {
        Map<Character, Character> seen = new HashMap<>();
        char next = 'a';
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!seen.containsKey(c)) {
                seen.put(c, next);
                ++next;
            }
            sb.append(seen.get(c));
        }
        return sb.toString();
    }
}