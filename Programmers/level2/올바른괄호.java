public class 올바른괄호 {
    boolean solution(String s) {
        int cnt = 0;

        for (int i = 0; i < s.length(); i++) {
            // 1. 문자열 안의 괄호 하나씩 빼기
            char c = s.charAt(i);

            //2. 왼쪽괄호 < 오른쪽괄호 개수가 되면 -1이 된다
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }

            // -1 이면 ")"가 먼저 나온것이므로 바로 false
            if (cnt < 0) {
                return false;
            }
        }

        // cnt가 0이라면 true
        return cnt == 0;
    }
}
