class Solution {
    
    char[] chars = {'A','E','I','O','U'};
    int count = 0;
    boolean flag = false;
    
    public int solution(String word) {
        dfs("", word);
        
        return count;
    }
    
    public void dfs(String str, String word){
        if(str.equals(word)){
            flag = true;
            return;
        }
        
        if(str.length() == 5) return;
        
        for(int i = 0 ; !flag && i < chars.length ; i++){
            count++;
            dfs(str + chars[i], word);
        }        
    }
}