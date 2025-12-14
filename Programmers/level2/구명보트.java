import java.util.*;

public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int min = 0;

        // 1. 몸무게 정렬
        Arrays.sort(people);

        // 2. 배열의 최솟값과 최댓값을 보고 같이 탈수있는지 확인 (투 포인터)
        for (int max = people.length - 1; min <= max; max--){
            // 3. 가장 가벼운 사람 + 가장 무거운 사람이 한 보트에 탈 수 있다면 태운다.
            if (people[min] + people[max] <= limit) {
                // 그 다음 값으로 넘어가서 같이 탈 수 있는지 비교
                min++;
            }
            answer++;
        }
        return answer;
    }
}
