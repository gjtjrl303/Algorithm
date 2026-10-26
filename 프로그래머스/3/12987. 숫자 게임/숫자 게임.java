import java.util.*;

class Solution {
    
    List<Integer> listA;
    List<Integer> listB;
    
    public int solution(int[] A, int[] B) {
        int count = 0;
        
        listA = new ArrayList<>();
        for(Integer a : A){
            listA.add(a);
        }
        Collections.sort(listA, (a,b) -> a-b);
        
        listB = new ArrayList<>();
        for(Integer b : B){
            listB.add(b);
        }
        Collections.sort(listB, (a,b) -> a-b);
        
        for(Integer target : listA){
            int targetBIndex = findTarget(0, listB.size() - 1, target);
            if(targetBIndex == - 1) targetBIndex = 0;
            while(targetBIndex < listB.size() && target >= listB.get(targetBIndex)){
                targetBIndex++;
            }
            
            
            if(targetBIndex < listB.size() && listB.get(targetBIndex) > target){
                count++;
                listB.remove(targetBIndex);
            }
        }
        
        return count;
    }
    
    int findTarget(int start, int end, int target){
        if(start >= end) return end;
        int mid = (start + end) / 2;
        if(listB.get(mid) == target) return mid;
        
        if(listB.get(mid) > target){
            end = mid - 1;
            return findTarget(start, end, target); 
        }else{
            start = mid + 1;
            return findTarget(start, end, target); 
        }    
    }
}