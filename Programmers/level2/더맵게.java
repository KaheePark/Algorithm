import java.util.*;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        // 배열의 최소값을 계속 구해야함 priorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // pq에 배열 넣기
        for (int s : scoville) {
            pq.add(s);
        }

        // pq[0]이 k보다 작을때까지 반복해서 계산
        // 계산 후에는 다시 pq에 넣어 정렬한 후 cnt++
        while (pq.peek() < K) {
            if (pq.size() >= 2) {
                int first = pq.poll(); // [0]
                int num = first + (pq.poll() * 2); // [1]
                pq.add(num); // 정렬
                cnt++;
            } else {
                cnt = -1;
                break;
            }
        }

        return cnt;
    }
}
