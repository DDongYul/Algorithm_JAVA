import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> idxMap = new HashMap<>();
        int N = friends.length;
        for(int i = 0; i<N; i++){
            idxMap.put(friends[i],i);
        }
        int[][] arr = new int[N][N];
        int[] sumArr = new int[N];
        for(int i = 0; i<gifts.length; i++){
            String a = gifts[i].split(" ")[0];
            String b = gifts[i].split(" ")[1];
            arr[idxMap.get(a)][idxMap.get(b)]+=1;
            sumArr[idxMap.get(a)] +=1;
            sumArr[idxMap.get(b)] -=1;
        }
        for(int i = 0; i<N; i++){
            int cnt=0;
            for(int j = 0; j<N; j++){
                if(i==j) continue;
                if(arr[i][j] > arr[j][i]){
                    cnt+=1;
                }else if(arr[i][j] == arr[j][i]){
                    if(sumArr[i]>sumArr[j]){
                        cnt+=1;
                    }
                }
            }
            answer = Math.max(answer,cnt);
        }
        return answer;
    }
}