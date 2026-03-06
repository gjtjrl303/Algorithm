class Solution {
    
    private final static int losted = 1;
    private final static int reserved = 2;
    private static int[] array;
    
    public int solution(int n, int[] lost, int[] reserve) {
        
        array = new int[n+1];
        
        for(int i = 0 ; i < lost.length ; i++){
            array[lost[i]] = losted;
        }
        
        for(int i = 0 ; i < reserve.length ; i++){
            if(array[reserve[i]] == losted){
                array[reserve[i]] = 0;
            }else{
                array[reserve[i]] = reserved;
            }
        }
        
        for(int i = 1 ; i <= n ; i++){
            if(array[i] == losted){
                if(i-1 >= 0 && array[i-1] == reserved) {
                    array[i] = 0;
                    array[i-1] = 0;
                }else if(i+1 <= n && array[i+1] == reserved){
                     array[i] = 0;
                    array[i+1] = 0;
                }
            }
        }
        
        int count = 0;
        for(int i = 1 ; i < array.length ; i++){
            if(array[i] != losted) count++;
        }

        return count;
    }
}