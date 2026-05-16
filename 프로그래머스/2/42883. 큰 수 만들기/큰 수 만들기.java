import java.util.*;

class Solution {
        
    public String solution(String number, int k) {
        
        int count = 0;
        int index = 0;
        StringBuilder sb = new StringBuilder(number);
        
        while(index < sb.length() - 1 && count != k){
            if(sb.charAt(index) < sb.charAt(index + 1)){
                sb.deleteCharAt(index);
                count++;
                if(index > 0) index--;
                continue;
            }
            index++;
        }
        
        System.out.println(count);
        
        if(count < k){
            sb.delete(sb.length() - (k - count), sb.length());
        }
        
        return sb.toString();
    }
}