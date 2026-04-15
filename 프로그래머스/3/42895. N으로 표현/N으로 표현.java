import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 8 ; i++){
            list.add(new ArrayList<>());
        }
        
        int temp = N;
        for(int i = 0; i < 8 ; i++){
            list.get(i).add(temp);
            temp*=10;
            temp+=N;  
        }
        
        for(int i = 0 ; i < 8 ; i++){
            System.out.println(list.get(i).get(0));
        }
        
        
        for(int i = 1 ; i < 8 ; i++){
            List<Integer> newList = list.get(i);
            for(int j = 0; j < i ; j++){
                List<Integer> list1 = list.get(j);
                List<Integer> list2 = list.get(i-j-1);
                for(Integer num1 : list1){
                    for(Integer num2 : list2){
                        newList.add(num1+num2);
                        newList.add(num1-num2);
                        newList.add(num1*num2);
                        if(num2 != 0){
                        newList.add(num1/num2);
                        }
                    }
                }
            }
        }
        
        for(int i = 0 ; i < 8 ; i++){
            List<Integer> tempList = list.get(i);
            
            for(Integer num : tempList){
                if(number == num) return i+1;
            }
        }
        return -1;
    }
}