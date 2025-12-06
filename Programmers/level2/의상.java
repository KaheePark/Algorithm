import java.util.*;
public class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        // 1. 옷을 종류별로 구분하기
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] cloth : clothes){
            // 종류에 없다면 1, 이미 있다면 +1로 늘려줌
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }

        // 2. 안입은 경우도 추가하여 모든 조합 계산하기
        for(Integer value : map.values()){
            answer *= value+1; // 안입은경우: +1
        }

        // 3. 모든 종류의 옷이 안입음인 경우 제외
        return answer -1 ;
    }
}
