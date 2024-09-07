class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String[] time = pos.split(":");
        int minute = Integer.parseInt(time[0]);
        int second = Integer.parseInt(time[1]);
        int curr = minute*60 + second;
        
        int osm = Integer.parseInt(op_start.split(":")[0]);
        int oss = Integer.parseInt(op_start.split(":")[1]);
        int ost = osm*60+oss;
        
        int oem = Integer.parseInt(op_end.split(":")[0]);
        int oes = Integer.parseInt(op_end.split(":")[1]);
        int oet = oem*60 + oes;
        
        int total = Integer.parseInt(video_len.split(":")[0]) * 60 + Integer.parseInt(video_len.split(":")[1]);
        
        for(String s : commands){
            if(ost<=curr && oet>=curr){
                curr = oet;
            }
            if(s.equals("prev")){
                curr-=10;
                curr = curr<0 ? 0 : curr;
                continue;
            }
            if(s.equals("next")){
                curr+=10;
                curr = curr>=total ? total : curr;
                continue;
            }
        }
        if(ost<=curr && oet>=curr){
                curr = oet;
            }
        
        int m = curr/60;
        int s = curr%60;
        String answer = "";
        if(m<=9){
            answer+="0";
        }
        answer+= m;
        answer+=":";
        if(s<=9){
            answer+="0";
        }
        answer+=s;
        return answer;
    }
}