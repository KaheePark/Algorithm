import java.lang.Math;
import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {

        // 1. 각 수포자 규칙 정의
        int[] first  = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third  = {3,3,1,1,2,2,4,4,5,5};

        int firCnt = 0;
        int secCnt = 0;
        int thrCnt = 0;

        // 2. answers 배열만큼 수포자 규칙 동일한지 확인 : O(N)
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i % first.length]) firCnt++;
            if(answers[i] == second[i % second.length]) secCnt++;
            if(answers[i] == third[i % third.length]) thrCnt++;
        }

        // 3. 맞은 개수 중 Max 값 뽑기
        int max = Math.max(firCnt, Math.max(secCnt,thrCnt));

        // 4. 맞은 개수 Max값이 동일하다면 오름차순으로
        ArrayList<Integer> list = new ArrayList<>();
        if(max == firCnt) list.add(1);
        if(max == secCnt) list.add(2);
        if(max == thrCnt) list.add(3);

        // 5. 배열로 변환
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
