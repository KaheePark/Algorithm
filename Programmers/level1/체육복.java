import java.util.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 자기 여벌체육복을 도난당한 경우 (같은번호일경우), 일치하는 배열의 숫자르 -1로 삭제처리
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j] == reserve[i]){
                    answer ++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        // 여벌 체육복 앞번호(-1) 혹은 뒷번호(+1)가 도난당한 경우, 일치하는 배열의 숫자르 -1로 삭제처리
        for(int i=0; i<reserve.length; i++){
            for(int j=0; j<lost.length; j++){
                if(lost[j] == reserve[i]-1 || lost[j] == reserve[i]+1){
                    answer ++;
                    lost[j] = -1;
                    reserve[i] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}
