import java.util.*;
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;

        // 1. (100-진도) / 속도로 개발일수를 구하고 큐에 삽입 : (O(N))
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                que.add((100 - progresses[i]) / speeds[i]);
            } else {
                que.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }

        // 2. 첫번째 큐 숫자부터 뒤의 숫자랑 비교
        int first = que.poll();

        // 3. 큐가 빌때까지 반복해서 비교 (앞의 숫자가 크면 카운트 & poll) : O(N)
        while (!que.isEmpty()) {
            if (first >= que.peek()) {
                cnt++;
                que.poll();
            } else {
                // 4. 뒤의 숫자가 더 크면 그 시점의 cnt는 배열에 담고, 해당 일수부터 카운트 1로 초기화
                list.add(cnt);
                cnt = 1;
                // 5. 첫번째 큐 숫자 변경
                first = que.poll();
            }
        }
        // 6. 마지막 계산된 카운트까지 리스트에 저장
        list.add(cnt);

        // 7. 리스트 반환 : (O(N))
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
