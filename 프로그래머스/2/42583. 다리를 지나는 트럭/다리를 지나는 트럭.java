import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int truckCount = truck_weights.length;
        int finished = 0;
        int time = 0;
        int truckWeightSum = 0;
        int truckIndex = 0;
        
        for(int i = 0 ; i < bridge_length ; i++){
            queue.add(0);
        }
        
        while(finished < truckCount){
            time++;
            int truckWeigth = queue.poll();
            truckWeightSum -= truckWeigth;
            if(truckWeigth != 0){
                finished++;
            }
            
            if(truckIndex < truckCount && truckWeightSum + truck_weights[truckIndex] <= weight){
                queue.add(truck_weights[truckIndex]);
                truckWeightSum += truck_weights[truckIndex++];
            }else{
                queue.add(0);
            }
        }
        return time;
    }   

}