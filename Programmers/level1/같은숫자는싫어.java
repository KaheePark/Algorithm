import java.util.*;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        int[] answer;
        int first = arr[0];

        // 1. 스택 생성 : O(1)
        Stack<Integer> st = new Stack<>();
        st.push(first);

        // 2. arr[1] 부터 앞의 숫자와 같은지 차례대로 비교
        // arr[i]이 peek의 숫자와 같다면 push&pop 으로 제거 : O(N)
        for(int i=1; i<=arr.length-1; i++){
            if(st.peek().equals(arr[i])){
                st.pop();
                st.push(arr[i]);
            } else {
                st.push(arr[i]);
            }
        }

        // 3. stack 크기만큼 배열 크기 선언 후 복사 : O(N)
        answer = new int[st.size()];
        for(int i=0; i<st.size(); i++){
            answer[i] = st.get(i);
        }
        return answer;
    }
}

