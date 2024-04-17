class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        while(idx<=n){
            int cnt = 0;
            for(int i = idx; i<=n; i++){
                cnt+=i;
                if(cnt==n){
                    answer+=1;
                    break;
                }
                if(cnt>n){
                    break;
                }
            }
            idx+=1;
        }
        return answer;
    }
}