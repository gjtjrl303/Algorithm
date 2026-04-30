import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int currentTime = 0;
        int timeSum = 0;
        List<Task> list = new LinkedList<>();
        PriorityQueue<Task> heap = new PriorityQueue<>();
        
        for(int i = 0 ; i < jobs.length ; i++){
            list.add(new Task(i, jobs[i][0], jobs[i][1]));
        }
        
        list.sort((t1,t2) -> t1.getStartTime() - t2.getStartTime());
        currentTime = list.get(0).getStartTime();
        
        while(!list.isEmpty() || !heap.isEmpty()){
            while(!list.isEmpty() && list.get(0).getStartTime() <= currentTime){
                heap.add(list.remove(0));   
            }
            
            if(!heap.isEmpty()){
                Task task = heap.remove();
                currentTime += task.getTime();
                timeSum += task.calculateTime(currentTime);
            }else{
                currentTime++;
            }
        }
        
        return (int) timeSum / jobs.length;
    }
    
    class Task implements Comparable<Task>{
        private int index;
        private int startTime;
        private int time;
        
        public Task(int index, int startTime, int time){
            this.index = index;
            this.startTime = startTime;
            this.time = time;
        }  
        
        @Override
        public int compareTo(Task another){
            if(time == another.getTime()){
                if(startTime == another.getStartTime()){
                    return index - another.getIndex();
                }
                return startTime - another.getStartTime();
            }
            return time - another.getTime();
        }
        
        public int calculateTime(int endTime){
            return endTime - startTime;
        }
          
        public int getIndex(){
            return index;
        }
        
        public int getStartTime(){
            return startTime;
        }
        
        public int getTime(){
            return time;
        }
    }
}