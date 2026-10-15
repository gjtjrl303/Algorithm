import java.util.*;

class Solution {
    public String solution(String p) {
        
        return recurision(p);
    }
    
    public String recurision(String p) {
        if(p.isEmpty()) return p;
        
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '(') count1++;
            if(p.charAt(i) == ')') count2++;
            if(count1 == count2) {
                String u = p.substring(0, i + 1);
                String v = p.substring(i + 1);
                if(right(u)) { 
                    return u + recurision(v);
                }
                else {
                    String tempString = "(";
                    tempString = tempString + recurision(v) + ")";
                    return tempString + changU(u);
                    
                }
            } 
        }
        return "";
    }
    
    public String changU(String u){
        u = u.substring(1, u.length() - 1);
        String tempString = "";
        for(int i = 0; i < u.length() ; i++){
            if(u.charAt(i) == '(') tempString += ')';
            if(u.charAt(i) == ')') tempString += '(';
        }
        return tempString;
    }
    
    public boolean right(String p){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < p.length() ; i++){
            if(p.charAt(i) == '(') {
                stack.push(p.charAt(i));
            }else if (p.charAt(i) == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) return true;
        return false;  
    }
}