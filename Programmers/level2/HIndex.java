import java.util.*;
public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); // 정렬

        // 논문 순회하기
        for(int i=0; i<citations.length; i++){
            // 남아있는 논문의 개수
            int h = citations.length - i;

            // 현재 논문의 인용횟수가 남은 논문의 개수보다 크거나 같을때 h 인덱스
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }
}
