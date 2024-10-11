import java.util.*;

class Solution {
    
    private static class Pair{
        int idx;
        int p;
        
        public Pair(int idx, int p){
            this.idx = idx;
            this.p = p;
        }
        
        public int compareTo(Pair pa){
            return pa.p - this.p;
        }
    }
    
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<Pair> deque = new ArrayDeque<>();
        for(int i = 0; i<priorities.length; i++){
            deque.add(new Pair(i, priorities[i]));
        }
        while(!deque.isEmpty()){
            Pair curr = deque.poll();
            boolean flag = true;
            for(Pair pa : deque){
                if(curr.p<pa.p){
                    deque.add(curr);
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer+=1;
                if(curr.idx == location){
                    break;
                }
            }
        }
        return answer;
    }
}