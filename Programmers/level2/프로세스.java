import java.util.*;
public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        // 1. 우선순위 큐 내림차순 생성
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        // 2. 우선순위 삽입 : O(N)
        for (int i = 0; i < priorities.length; i++) {
            que.add(priorities[i]);
        }

        // 3. 큐 빌떄까지 반복 : O(N2)
        while (!que.isEmpty()) {
            // 4. 우선순위 배열 순회하면서 맨 앞 숫자 비교
            for (int i = 0; i < priorities.length; i++) {
                // 5. 가장 우선순위가 높은 숫자 = priorities 배열 숫자일떄 뽑기
                if (que.peek() == priorities[i]) {
                    que.poll();
                    // 6. 프로세스 수 +1
                    answer++;
                    // 7. location = i일때 반환
                    if (location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}
