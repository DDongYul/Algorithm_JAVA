import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(citations);
        for(int i=0; i<10000; i++){
            if((citations.length-idx) == i){
                return i;
            }
            while(i>=citations[idx]){
                idx++;
                if(idx>=citations.length){
                    break;
                }
                if((citations.length-idx) == i){
                return i;
            }
            }
            if(idx>=citations.length){
                    break;
                }
        }
        return answer;
    }
}