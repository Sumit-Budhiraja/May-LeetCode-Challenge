class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        solve(new int[n], 0, res);
        return res;
    }
    
    private void solve(int[] pos, int it, List<List<String>> sol) {
        if (it == pos.length) {
            saveAnswer(pos, sol);
            return;
        }
        for (int i = 0; i < pos.length; i++) {
            pos[it] = i;
            
            boolean ok = true;
            for (int j = 0; j < it; j++) {
                if (pos[it] == pos[j] || Math.abs(pos[it] - pos[j]) == it - j) {
                    ok = false; break; 
                }
            }
            if (ok) {
                solve(pos, it + 1, sol);
            }
        }
    }
    
    private void saveAnswer(int[] pos, List<List<String>> sol) {
        List<String> res = new ArrayList<>();
        for (int p: pos) {
            res.add(rowString(p, pos.length));
        }
        sol.add(res);
    }
    
    private String rowString(int i, int n) {
        char[] chars = new char[n];
        Arrays.fill(chars, '.');
        chars[i] = 'Q';
        return String.valueOf(chars);
    }
}