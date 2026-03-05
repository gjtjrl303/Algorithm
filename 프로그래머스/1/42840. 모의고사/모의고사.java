import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] answers) {
        
        List<Integer> list = new ArrayList<>();
        
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] answer = {};
        int count1 = 0, count2 = 0, count3 = 0;
        
        for(int i = 0 ; i < answers.length ; i++){
            if(student1[i%student1.length] == answers[i]) count1++;
            if(student2[i%student2.length] == answers[i]) count2++;
            if(student3[i%student3.length] == answers[i]) count3++;
        }
        
        int max = 0;
        max = Math.max(max, count1);
        max = Math.max(max, count2);
        max = Math.max(max, count3);
        
        if(count1 == max) list.add(1);
        if(count2 == max) list.add(2);
        if(count3 == max) list.add(3);
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}