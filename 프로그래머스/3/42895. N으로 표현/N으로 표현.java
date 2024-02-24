/*
 * N개로 만들 수 있는 정수 -> N-1개로 만들 수 있는 정수에 사칙연산
 * 추가로 숫자 하나 붙여주는 것은 예외처리
 */
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int solution(int N, int number) {
        if(N == number){
            return 1;
        }

        Set<Integer>[] sets = new Set[9];
        for (int i = 0; i < 9; i++) {
            sets[i] = new HashSet<>();
        }
        for (int i = 1; i < 9; i++) {
            int num = N;
            for (int j = 1; j < i; j++) {
                num+= N*Math.pow(10,j);
            }
            if(num == number){
                return i;
            }
            sets[i].add(num);
        }

        for (int i = 2; i < 9; i++) {
            int p1 = 1;
            int p2 = i-1;
            while (p1<=i-1){
                Set<Integer> s1 = sets[p1];
                Set<Integer> s2 = sets[p2];
                for (Integer i1 : s1) {
                    for (Integer i2 : s2) {
                        if(i2 == 0){
                            continue;
                        }
                        if(i1+i2 == number || i1-i2 == number || i1*i2 == number || i1/i2 == number){
                            return i;
                        }
                        sets[i].add(i1+i2);
                        sets[i].add(i1-i2);
                        sets[i].add(i1*i2);
                        sets[i].add(i1/i2);
                    }
                }

                p1++;
                p2--;
            }
        }
        return -1;
    }
}