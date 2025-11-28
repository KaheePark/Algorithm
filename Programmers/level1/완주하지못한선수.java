import java.util.*;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // HashMap 생성
        Map<String, Integer> map = new HashMap<>();

        // participant 배열 Map으로 생성, key = 이름, value = 1
        for(String p : participant){
            map.put(p, map.getOrDefault(p, 0)+1);
        }

        // completion 배열 이름 확인해서 value -1 (중복값 덮어쓰기)
        for(String c : completion){
            map.put(c, map.get(c)-1); // 중복값이 없는(완주x 선수) 값은 덮어쓰기 x 로 1 유지
        }

        // value 값이 0이 아닌 사람의 이름을 반환
        for(String k : map.keySet()){
            if(map.get(k) != 0){
                answer = k;
            }
        }
        return answer;
    }
}
